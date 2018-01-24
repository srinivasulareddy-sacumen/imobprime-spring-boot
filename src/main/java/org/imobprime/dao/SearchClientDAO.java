package org.imobprime.dao;

import java.util.List;

import org.imobprime.controller.ClientSearchDTO;
import org.imobprime.model.Client;

public interface SearchClientDAO {

	List<Client> findAll(ClientSearchDTO clientSearchDTO);
	
}
