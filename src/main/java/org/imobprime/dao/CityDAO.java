package org.imobprime.dao;

import java.util.List;
import java.util.Map;

import org.imobprime.model.City;

public interface CityDAO {

	public List<City> findAll(Map<String, String> parameters);
	
	public List<City> findAllByName(String cityName);
	
	public City findOneByNameAndStateAbbreviation(String cityName, String stateAbbreviation);
	
	public City findOneById(Integer id);
	
}
