package org.imobprime.service;

import java.util.List;

import org.imobprime.model.Agent;

public interface AgentService {

	List<Agent> findAll();
	
	List<Agent> findAll(String name, String cpf, Integer creci, Integer realEstateId, Integer stateId, Integer cityId);

	Agent findById(Integer agentId);

	void save(Agent agent);

	void update(Agent agent);

	void deleteById(Integer agentId);
	
}
