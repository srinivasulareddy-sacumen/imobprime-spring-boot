package org.imobprime.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.imobprime.controller.PropertySearchDTO;
import org.imobprime.dao.PropertyDAO;
import org.imobprime.model.Property;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyJPA implements PropertyDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Property> findAll() {
		TypedQuery<Property> query = entityManager.createQuery(
			"select p from Property p "
		  + "left join fetch p.type "
		  + "left join fetch p.state "
		  + "order by p.id DESC", Property.class);
		
		query.setMaxResults(25);
		
		return query.getResultList();
	}

	@Override
	public List<Property> findAll(PropertySearchDTO clientSearchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
