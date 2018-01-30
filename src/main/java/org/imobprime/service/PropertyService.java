package org.imobprime.service;

import java.util.List;

import org.imobprime.controller.PropertySearchDTO;
import org.imobprime.model.Property;

public interface PropertyService {

	List<Property> findAll();
	
	List<Property> findAll(PropertySearchDTO clientSearchDTO);

	Property findById(Integer clientId);

	void save(Property client);

	void update(Property client);

	void deleteById(Integer clientId);
	
}
