package org.imobprime.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.imobprime.dao.PropertyStateDAO;
import org.imobprime.model.PropertyState;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyStateJPA implements PropertyStateDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<PropertyState> findAll() {
		TypedQuery<PropertyState> query = entityManager.createQuery(
			"select p from PropertyState p "
		  + "order by p.name ASC", PropertyState.class);
			
		return query.getResultList();
	}
	
}
