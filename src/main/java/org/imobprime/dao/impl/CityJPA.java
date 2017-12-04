package org.imobprime.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.imobprime.dao.CityDAO;
import org.imobprime.model.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityJPA implements CityDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<City> findAll(Map<String, String> parameters) {
		final String name = parameters.get("name").trim();
		final String stateId = parameters.get("stateId");
				
		TypedQuery<City> query = entityManager.createQuery(getQueryStr(name, stateId), City.class);
			
		query.setMaxResults(25);
		
		if (!"".equals(name)) {
			query.setParameter("name", "%" + name + "%");
		}
		
		if (!"".equals(stateId)) {
			query.setParameter("stateId", Integer.parseInt(stateId));
		}
		
		return query.getResultList();
	}

	private String getQueryStr(final String name, final String stateId) {
		String queryStr = "SELECT c FROM City c "
				  		+ "LEFT JOIN FETCH c.state s "; 

		if (!"".equals(name)) {
			queryStr += "WHERE c.name LIKE :name ";
		}
		
		if (!"".equals(stateId)) {
			if(queryStr.contains("WHERE"))
				queryStr += "AND s.id = :stateId ";
			else
				queryStr += "WHERE s.id = :stateId ";
		}
		
		queryStr += "ORDER BY c.name ASC";
		return queryStr;
	}

}
