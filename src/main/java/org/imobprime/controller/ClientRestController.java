package org.imobprime.controller;

import java.util.List;

import org.imobprime.model.Client;
import org.imobprime.service.ClientService;
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
public class ClientRestController {

	public static final Logger logger = LoggerFactory.getLogger(ClientRestController.class);

	@Autowired
	ClientService clientService;

	@GetMapping("clients")
	public ResponseEntity<?> listAll() {
		logger.info("Fetching all clients.");
		List<Client> clients = clientService.findAll();

		if (clients.isEmpty()) {
			logger.info("There is no clients in database.");
			// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

}
