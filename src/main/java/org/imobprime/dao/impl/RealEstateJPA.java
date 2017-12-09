package org.imobprime.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.imobprime.dao.RealEstateDAO;
import org.imobprime.model.RealEstate;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class RealEstateJPA implements RealEstateDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<RealEstate> findAll() {
		TypedQuery<RealEstate> query = entityManager.createQuery(
			"select r from RealEstate r "
		  + "left join fetch r.addressZipCode z "
		  + "left join fetch z.city c "
	  	  + "left join fetch c.state s "
		  + "order by r.name ASC", RealEstate.class);
		
		query.setMaxResults(25);
		return query.getResultList();
	}

	@Override
	public List<RealEstate> findAll(Map<String, String> parameters) {
		String queryStr = createQueryStringByParameters(parameters);
		
		TypedQuery<RealEstate> query = entityManager.createQuery(queryStr, RealEstate.class);
		
		if (parameters.get("name") != null && !parameters.get("name").trim().equals("")) {
			query.setParameter("name", "%" + parameters.get("name") + "%");
		}
		
		if (parameters.get("cnpj") != null && !parameters.get("cnpj").trim().equals("")) {
			query.setParameter("cnpj", "%" + parameters.get("cnpj") + "%");
		}
		
		if (parameters.get("stateId") != null && !parameters.get("stateId").equals("")) {
			query.setParameter("stateId", Integer.parseInt(parameters.get("stateId")));
		}
		
		if (parameters.get("cityId") != null && !parameters.get("cityId").equals("")) {
			query.setParameter("cityId", Integer.parseInt(parameters.get("cityId")));
		}
		
		query.setMaxResults(25);
		return query.getResultList();
	}

	private String createQueryStringByParameters(Map<String, String> parameters) {
		String queryStr = "select r from RealEstate r "
				  		+ "left join fetch r.addressZipCode z "
				  		+ "left join fetch z.city c "
				  		+ "left join fetch c.state s ";
				
		if (parameters.get("name") != null && !parameters.get("name").trim().equals("")) {
			queryStr += "WHERE r.name LIKE :name ";
		}
		
		if (parameters.get("cnpj") != null && !parameters.get("cnpj").trim().equals("")) {
			if(queryStr.contains("WHERE"))
				queryStr += "AND CAST(r.cnpj AS string) LIKE :cnpj ";
			else
				queryStr += "WHERE CAST(r.cnpj AS string) LIKE :cnpj ";
		}
		
		if (parameters.get("stateId") != null && !parameters.get("stateId").equals("")) {
			if(queryStr.contains("WHERE"))
				queryStr += "AND s.id = :stateId ";
			else
				queryStr += "WHERE s.id = :stateId ";
		}
		
		if (parameters.get("cityId") != null && !parameters.get("cityId").equals("")) {
			if(queryStr.contains("WHERE"))
				queryStr += "AND c.id = :cityId ";
			else
				queryStr += "WHERE c.id = :cityId ";
		}
		
		queryStr += "ORDER BY r.name ASC";
		return queryStr;
	}

}
