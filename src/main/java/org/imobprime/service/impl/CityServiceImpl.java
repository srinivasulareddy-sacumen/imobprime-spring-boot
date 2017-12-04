package org.imobprime.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.imobprime.dao.CityDAO;
import org.imobprime.model.City;
import org.imobprime.repository.CityRepository;
import org.imobprime.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CityDAO cityDAO;

	@Override
	public List<City> findAll() {
		PageRequest request = new PageRequest(0, 25, Sort.Direction.ASC, "name");
		return cityRepository.findAll(request).getContent();
	}

	@Override
	public List<City> findAll(String name, Integer stateId) {
		Map<String, String> parameters = new HashMap<>();
		
		if (name != null) {
			parameters.put("name", name.trim());
		} else {
			parameters.put("name", "");
		}
		
		if(stateId == null)
			parameters.put("stateId", "");
		else
			parameters.put("stateId", String.valueOf(stateId));
				
		return cityDAO.findAll(parameters);
	}

}
