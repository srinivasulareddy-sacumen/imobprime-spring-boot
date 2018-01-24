package org.imobprime.service;

import java.util.List;

import org.imobprime.controller.ClientSearchDTO;
import org.imobprime.model.Client;

public interface ClientService {

	List<Client> findAll();
	
	List<Client> findAll(ClientSearchDTO clientSearchDTO);

	Client findById(Integer clientId);

	void save(Client client);

	void update(Client client);

	void deleteById(Integer clientId);

}
