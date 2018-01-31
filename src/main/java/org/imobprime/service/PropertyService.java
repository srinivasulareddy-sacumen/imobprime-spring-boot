package org.imobprime.service;

import java.util.List;

import org.imobprime.controller.PropertySearchDTO;
import org.imobprime.model.Property;

public interface PropertyService {

	List<Property> findAll();
	
	List<Property> findAll(PropertySearchDTO propertySearchDTO);

	Property findById(Integer propertyId);

	void save(Property property);

	void update(Property property);

	void deleteById(Integer propertyId);
	
}
