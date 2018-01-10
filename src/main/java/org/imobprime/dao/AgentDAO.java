package org.imobprime.dao;

import java.util.List;
import java.util.Map;

import org.imobprime.model.Agent;

public interface AgentDAO {

	public List<Agent> findAll();

	public List<Agent> findAll(Map<String, String> parameters);
	
}
