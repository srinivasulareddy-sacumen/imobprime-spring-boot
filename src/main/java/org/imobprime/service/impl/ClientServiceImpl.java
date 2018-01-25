package org.imobprime.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.imobprime.controller.ClientSearchDTO;
import org.imobprime.dao.ClientDAO;
import org.imobprime.dao.SearchClientDAO;
import org.imobprime.model.Agent;
import org.imobprime.model.Client;
import org.imobprime.repository.ClientRepository;
import org.imobprime.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ClientDAO clientDAO;
	
	@Autowired
	SearchClientDAO searchClientDAO;
	
	@Override
	public List<Client> findAll() {
		List<Client> clients = clientDAO.findAll();
		
		return clients.stream()
				.map(client -> {
					client.getAgent().setRealEstate(null);
					client.getAgent().setCity(null);
					client.getAgent().setState(null);
					return client;
				})
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Client> findAll(ClientSearchDTO clientSearchDTO) {
		// this implementation was not used because of mysql JSON data type
        // stateId and cityId are inside a JSON column in cliente table
		
//		List<Client> clients = clientDAO.findAll(clientSearchDTO);
//		
//		return clients.stream()
//				.map(client -> {
//					client.getAgent().setRealEstate(null);
//					client.getAgent().setCity(null);
//					client.getAgent().setState(null);
//					return client;
//				})
//				.collect(Collectors.toList());
		
		return searchClientDAO.findAll(clientSearchDTO);
	}

	@Override
	public Client findById(Integer clientId) {
		Client client = clientDAO.findOne(clientId);
		
		client.getAgent().setRealEstate(null);
		client.getAgent().setCity(null);
		client.getAgent().setState(null);
		
		return client;
	}

	@Override
	@Transactional
	public void save(Client client) {
		Agent agent = new Agent();
		agent.setId(1);
		
		client.setAgent(agent);
		clientRepository.save(client);
	}

	@Override
	@Transactional
	public void update(Client client) {
		clientRepository.save(client);
	}

	@Override
	@Transactional
	public void deleteById(Integer clientId) {
		clientRepository.delete(clientId);
	}

}
