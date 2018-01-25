package org.imobprime.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.imobprime.controller.ClientSearchDTO;
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
	public List<Client> findAll(ClientSearchDTO clientSearchDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = builder.createQuery(Client.class);
        Root<Client> from = query.from(Client.class);
 
        From<?, ?> agent = (From<?, ?>) from.fetch("agent");
        agent.fetch("state");
        agent.fetch("city");
        
        From<?, ?> realEstate = (From<?, ?>) agent.fetch("realEstate");
        realEstate.fetch("addressZipCode");
        
        Predicate predicate = builder.conjunction();
        
        if(!"".equals(clientSearchDTO.getName().trim())) {
        	predicate = builder.and(predicate, 
        		builder.like(from.get("name"), "%" + clientSearchDTO.getName() + "%"));
        }
        
        if(!"".equals(clientSearchDTO.getCpf().trim())) {
        	predicate = builder.and(predicate, 
        		builder.like(from.get("cpf"), "%" + clientSearchDTO.getCpf() + "%"));
        }
        
        // this method was not used because mysql JSON data type
        // stateId and cityId are inside a JSON column
        
        query.where(predicate);
        
        query.orderBy(builder.asc(from.get("name")));
        
        TypedQuery<Client> typedQuery = entityManager.createQuery(query);
        typedQuery.setMaxResults(25);
        
        return typedQuery.getResultList();
	}

	@Override
	public Client findOne(Integer id) {
		TypedQuery<Client> query = entityManager.createQuery(
			"select cli from Client cli "
		  + "left join fetch cli.agent ag "
		  + "left join fetch ag.state "
		  + "left join fetch ag.city "
		  + "left join fetch ag.realEstate real "
		  + "left join fetch real.addressZipCode "
		  + "where cli.id = :id", Client.class);

		query.setMaxResults(1);
		query.setParameter("id", id);
		return query.getResultList().get(0);
	}

}
