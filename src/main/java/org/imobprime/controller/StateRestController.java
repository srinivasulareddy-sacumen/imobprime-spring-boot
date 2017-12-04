package org.imobprime.controller;

import java.util.List;

import org.imobprime.model.State;
import org.imobprime.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class StateRestController {

	public static final Logger logger = LoggerFactory.getLogger(StateRestController.class);
	
	@Autowired
	StateService stateService;
	
	@GetMapping("states")
	public ResponseEntity<?> listAll() {
		logger.info("Fetching all states.");
		List<State> states = stateService.findAll();

		if (states.isEmpty()) {
			logger.info("There is no states in database.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(states, HttpStatus.OK);
	}
	
}
