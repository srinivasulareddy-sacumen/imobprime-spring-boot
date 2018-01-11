package org.imobprime.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.imobprime.controller.AgentSearchDTO;
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
	public List<Agent> findAll(AgentSearchDTO agentSearchDTO) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("name", agentSearchDTO.getName());
		parameters.put("cpf", agentSearchDTO.getCpf());
		
		if(agentSearchDTO.getCreci() == null)
			parameters.put("creci", "");
		else
			parameters.put("creci", String.valueOf(agentSearchDTO.getCreci()));
		
		if(agentSearchDTO.getRealEstateId() == null)
			parameters.put("realEstateId", "");
		else
			parameters.put("realEstateId", String.valueOf(agentSearchDTO.getRealEstateId()));
		
		if(agentSearchDTO.getStateId() == null)
			parameters.put("stateId", "");
		else
			parameters.put("stateId", String.valueOf(agentSearchDTO.getStateId()));
		
		if(agentSearchDTO.getCityId() == null)
			parameters.put("cityId", "");
		else
			parameters.put("cityId", String.valueOf(agentSearchDTO.getCityId()));
		
		List<Agent> agents = agentDAO.findAll(parameters);
		
		return agents.stream()
			.map(a -> {
				a.getRealEstate().setAddressZipCode(null);
				return a;
			})
			.collect(Collectors.toList());
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
