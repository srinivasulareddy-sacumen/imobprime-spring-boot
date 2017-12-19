package org.imobprime.service;

import java.util.List;

import org.imobprime.model.State;

public interface StateService {

	List<State> findAll();
	
	State findByAbbreviation(String abbreviation);
	
}
