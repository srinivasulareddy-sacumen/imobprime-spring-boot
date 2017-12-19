package org.imobprime.service.impl;

import java.util.List;

import org.imobprime.model.State;
import org.imobprime.repository.StateRepository;
import org.imobprime.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;
	
	@Override
	public List<State> findAll() {
		Sort sort = new Sort(Sort.Direction.ASC, "name");
		return stateRepository.findAll(sort);
	}

	@Override
	public State findByAbbreviation(String abbreviation) {
		return stateRepository.findByStateAbbreviation(abbreviation);
	}

}
