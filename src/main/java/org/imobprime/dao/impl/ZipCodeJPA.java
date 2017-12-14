package org.imobprime.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.imobprime.dao.ZipCodeDAO;
import org.imobprime.model.ZipCode;
import org.springframework.stereotype.Repository;

@Repository
public class ZipCodeJPA implements ZipCodeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ZipCode findOne(String postalCode) {
		TypedQuery<ZipCode> query = entityManager.createQuery(
			"select zip from ZipCode zip "
		  + "left join fetch zip.city c "
	  	  + "left join fetch c.state s "
	  	  + "where zip.postalCode = :postalCode", ZipCode.class);
			
		query.setMaxResults(1);
		query.setParameter("postalCode", postalCode);
		return query.getResultList().get(0);
	}

}
