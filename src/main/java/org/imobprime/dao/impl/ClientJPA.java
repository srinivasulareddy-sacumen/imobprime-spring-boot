package org.imobprime.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.imobprime.dao.ClientDAO;
import org.imobprime.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientJPA implements ClientDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Client> findAll() {
		TypedQuery<Client> query = entityManager.createQuery(
			"select cli from Client cli "
		  + "left join fetch cli.agent ag "
		  + "left join fetch ag.state "
		  + "left join fetch ag.city "
		  + "left join fetch ag.realEstate real "
		  + "left join fetch real.addressZipCode "
		  + "order by cli.name ASC", Client.class);
		
		query.setMaxResults(25);
		
		return query.getResultList();
	}

	@Override
	public List<Client> findAll(Map<String, String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
