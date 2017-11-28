package org.imobprime.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.imobprime.model.RealEstate;
import org.springframework.stereotype.Component;

@Component
public class RealEstateJPA implements RealEstateDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<RealEstate> findAll() {
		TypedQuery<RealEstate> query = entityManager.createQuery(
			"select r from RealEstate r left join fetch r.addressZipCode order by r.name ASC", RealEstate.class);    
		query.setMaxResults(25);
		return query.getResultList();
	}

}
