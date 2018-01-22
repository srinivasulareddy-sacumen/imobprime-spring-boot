package org.imobprime.dao;

import java.util.List;
import java.util.Map;

import org.imobprime.model.Client;

public interface ClientDAO {

	public List<Client> findAll();

	public List<Client> findAll(Map<String, String> parameters);
	
	public Client findOne(Integer id);
	
}
