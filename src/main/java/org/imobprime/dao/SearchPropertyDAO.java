package org.imobprime.dao;

import java.util.List;
import java.util.Map;

import org.imobprime.model.Property;

public interface SearchPropertyDAO {

	public List<Property> findAllMostRecent(Map<String, String> parameters);
	
}
