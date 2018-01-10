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
		  + "order by ag.name ASC", Agent.class);
		
		query.setMaxResults(25);
		return query.getResultList();
	}

	@Override
	public List<Agent> findAll(Map<String, String> parameters) {

		return null;
	}

}
