package org.imobprime.service;

import java.util.List;

import org.imobprime.controller.AgentSearchDTO;
import org.imobprime.model.Agent;

public interface AgentService {

	List<Agent> findAll();
	
	List<Agent> findAll(AgentSearchDTO agentSearchDTO);

	Agent findById(Integer agentId);

	void save(Agent agent);

	void update(Agent agent);

	void deleteById(Integer agentId);
	
}
