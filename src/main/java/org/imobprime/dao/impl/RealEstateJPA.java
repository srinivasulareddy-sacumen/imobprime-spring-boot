package org.imobprime.dao.impl;

import java.util.List;

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
		  + "left join fetch r.addressZipCode "
		  + "order by r.name ASC", RealEstate.class);
		
		query.setMaxResults(25);
		return query.getResultList();
	}

}
