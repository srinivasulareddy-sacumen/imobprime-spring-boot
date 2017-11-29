package org.imobprime.dao;

import java.util.List;
import java.util.Map;

import org.imobprime.model.RealEstate;

public interface RealEstateDAO {

	public List<RealEstate> findAll();

	public List<RealEstate> findAll(Map<String, String> parameters);
	
}
