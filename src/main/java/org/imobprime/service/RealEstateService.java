package org.imobprime.service;

import java.util.List;
import java.util.Map;

import org.imobprime.model.RealEstate;

public interface RealEstateService {
	
	List<RealEstate> findAll();
	
	List<RealEstate> findAll(Map<String, String> parameters);

	RealEstate findById(Integer id);

	void save(RealEstate realEstate);

	void update(RealEstate realEstate);

	void deleteById(Integer id);

}
