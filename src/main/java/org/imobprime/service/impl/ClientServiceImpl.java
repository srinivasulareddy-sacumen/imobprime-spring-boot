package org.imobprime.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.imobprime.controller.ClientSearchDTO;
import org.imobprime.dao.ClientDAO;
import org.imobprime.dao.SearchClientDAO;
import org.imobprime.model.Client;
import org.imobprime.repository.ClientRepository;
import org.imobprime.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer clientId) {
		// TODO Auto-generated method stub
		
	}

}
