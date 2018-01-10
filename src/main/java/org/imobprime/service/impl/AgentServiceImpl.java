package org.imobprime.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.imobprime.dao.AgentDAO;
import org.imobprime.model.Agent;
import org.imobprime.repository.AgentRepository;
import org.imobprime.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	AgentDAO agentDAO;
	
	@Override
	public List<Agent> findAll() {
		List<Agent> agents = agentDAO.findAll();
		
		return agents.stream()
				.map(a -> {
					a.getRealEstate().setAddressZipCode(null);
					return a;
				})
				.collect(Collectors.toList());
	}

	@Override
	public List<Agent> findAll(String name, String cpf, Integer creci, Integer realEstateId, Integer stateId,
			Integer cityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent findById(Integer agentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(Agent agent) {
		agentRepository.save(agent);
	}

	@Override
	@Transactional
	public void update(Agent agent) {
		agentRepository.save(agent);
	}

	@Override
	@Transactional
	public void deleteById(Integer agentId) {
		agentRepository.delete(agentId);
	}

}
