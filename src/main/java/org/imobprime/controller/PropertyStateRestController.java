package org.imobprime.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.imobprime.dao.PropertyStateDAO;
import org.imobprime.model.PropertyState;
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
public class PropertyStateRestController {

	@Autowired
	PropertyStateDAO propertyStateDAO;
	
	@GetMapping("/propertyStates")
	public ResponseEntity<?> listAll() {
		List<PropertyState> propertyStates = propertyStateDAO.findAll()
			.stream()
			.sorted(Comparator.comparing(PropertyState::getName))
			.collect(Collectors.toList());
			
		return new ResponseEntity<>(propertyStates, HttpStatus.OK);
	}
	
}
