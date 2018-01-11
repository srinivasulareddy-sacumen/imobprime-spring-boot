package org.imobprime.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.imobprime.dao.AgentDAO;
import org.imobprime.model.Agent;
import org.springframework.stereotype.Repository;

@Repository
public class AgentJPA implements AgentDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Agent> findAll() {
		TypedQuery<Agent> query = entityManager.createQuery(
			"select ag from Agent ag "
		  + "left join fetch ag.realEstate r "
		  + "left join fetch ag.city c "
	  	  + "left join fetch ag.state s "
	  	  + "left join fetch c.state "
	  	  + "left join fetch r.addressZipCode " // TODO this join avoids multiple selects, replace eager to lazy
		  + "order by ag.name ASC", Agent.class);
		
		query.setMaxResults(25);
		return query.getResultList();
	}

	@Override
	public List<Agent> findAll(Map<String, String> parameters) {		
		TypedQuery<Agent> query = entityManager.createQuery(getQueryStringFromParameters(parameters), Agent.class);
		
		if (!parameters.get("name").trim().equals("")) {
			query.setParameter("name", "%" + parameters.get("name") + "%");
		}
		
		if (!parameters.get("cpf").trim().equals("")) {
			query.setParameter("cpf", "%" + parameters.get("cpf") + "%");
		}
		
		if (!parameters.get("creci").trim().equals("")) {
			query.setParameter("creci", "%" + parameters.get("creci") + "%");
		}
		
		if (!parameters.get("realEstateId").equals("")) {
			query.setParameter("realEstateId", Integer.parseInt(parameters.get("realEstateId")));
		}
		
		if (!parameters.get("stateId").equals("")) {
			query.setParameter("stateId", Integer.parseInt(parameters.get("stateId")));
		}
		
		if (!parameters.get("cityId").equals("")) {
			query.setParameter("cityId", Integer.parseInt(parameters.get("cityId")));
		}
		
		query.setMaxResults(25);
		
		return query.getResultList();
	}

	private String getQueryStringFromParameters(Map<String, String> parameters) {
		String queryStr = 
			"select ag from Agent ag "
		  + "left join fetch ag.realEstate r "
		  + "left join fetch ag.city c "
	  	  + "left join fetch ag.state s "
	  	  + "left join fetch c.state "
	  	  + "left join fetch r.addressZipCode "; // TODO this join avoids multiple selects, replace eager to lazy
		
		if (!parameters.get("name").trim().equals("")) {
			queryStr += "WHERE ag.name LIKE :name ";
		}
		
		if (!parameters.get("cpf").trim().equals("")) {
			if(queryStr.contains("WHERE"))
				queryStr += "AND ag.cpf LIKE :cpf ";
			else
				queryStr += "WHERE ag.cpf LIKE :cpf ";
		}
		
		if (!parameters.get("creci").trim().equals("")) {
			if(queryStr.contains("WHERE"))
				queryStr += "AND CAST(ag.creci AS string) LIKE :creci ";
			else
				queryStr += "WHERE CAST(ag.creci AS string) LIKE :creci ";
		}
		
		if (!parameters.get("realEstateId").equals("")) {
			if(queryStr.contains("WHERE"))
				queryStr += "AND r.id = :realEstateId ";
			else
				queryStr += "WHERE r.id = :realEstateId ";
		}
		
		if (!parameters.get("stateId").equals("")) {
			if(queryStr.contains("WHERE"))
				queryStr += "AND s.id = :stateId ";
			else
				queryStr += "WHERE s.id = :stateId ";
		}
		
		if (!parameters.get("cityId").equals("")) {
			if(queryStr.contains("WHERE"))
				queryStr += "AND c.id = :cityId ";
			else
				queryStr += "WHERE c.id = :cityId ";
		}
		
		queryStr += "order by ag.name ASC";
		return queryStr;
	}

}
