package org.imobprime.dao;

import java.util.List;

import org.imobprime.controller.ClientSearchDTO;
import org.imobprime.model.Client;

public interface ClientDAO {

	public List<Client> findAll();

	public List<Client> findAll(ClientSearchDTO clientSearchDTO);
	
	public Client findOne(Integer id);
	
}
