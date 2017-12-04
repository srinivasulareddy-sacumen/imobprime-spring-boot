package org.imobprime.service;

import java.util.List;

import org.imobprime.model.City;

public interface CityService {

	List<City> findAll();
	
	List<City> findAll(String name, Integer stateId);
	
}
