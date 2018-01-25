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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ClientRestController {

	public static final Logger logger = LoggerFactory.getLogger(ClientRestController.class);

	@Autowired
	ClientService clientService;

	@GetMapping("/clients")
	public ResponseEntity<?> listAll() {
		logger.info("Fetching all clients.");
		List<Client> clients = clientService.findAll();

		if (clients.isEmpty()) {
			logger.info("There is no clients in database.");
			// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(clients, HttpStatus.OK);
	}
	
	@PostMapping("/search-clients")
	public ResponseEntity<?> listAll(@RequestBody ClientSearchDTO clientSearchDTO) {
		logger.info("Fetching all clients by params.");
		List<Client> clients = clientService.findAll(clientSearchDTO);

		if (clients.isEmpty()) {
			logger.info("There is no clients in database.");
			// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getById(@PathVariable("id") Integer id) {
		logger.info("Fetching the client by id.");
		Client client = clientService.findById(id);
		
		logger.info("Client fetched with sucess.");
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@PostMapping("/clients")
	public ResponseEntity<Client> save(@RequestBody Client client) {
		logger.info("Saving the client.");
		clientService.save(client);
		
		logger.info("Client saved with success.");
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PutMapping("/clients")
	public ResponseEntity<Void> update(@RequestBody Client client) {
		// TODO: logger.info("Updating the client.");
		clientService.update(client);
		
		logger.info("Client updated with success.");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		logger.info("Deleting the client by id.");
		clientService.deleteById(id);
		
		logger.info("Client deleted with success.");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
