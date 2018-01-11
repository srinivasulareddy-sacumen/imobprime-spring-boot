package org.imobprime.controller;

import java.util.List;

import org.imobprime.model.Agent;
import org.imobprime.service.AgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class AgentRestController {

	public static final Logger logger = LoggerFactory.getLogger(AgentRestController.class);
	
	@Autowired
	AgentService agentService;
	
	@GetMapping("agents")
	public ResponseEntity<?> listAll() {
		logger.info("Fetching all agents.");
		List<Agent> agents = agentService.findAll();

		if (agents.isEmpty()) {
			logger.info("There is no agents in database.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(agents, HttpStatus.OK);
	}
	
	@PostMapping("searchAgents")
	public ResponseEntity<?> listAll(@RequestBody AgentSearchDTO agentSearchDTO) {
		logger.info("Fetching all agents by params.");
		List<Agent> agents = agentService.findAll(agentSearchDTO);

		if (agents.isEmpty()) {
			logger.info("There is no agents in database.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(agents, HttpStatus.OK);
	}
	
}
