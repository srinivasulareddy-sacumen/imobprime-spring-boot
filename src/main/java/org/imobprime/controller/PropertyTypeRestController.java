package org.imobprime.controller;

import java.util.List;

import org.imobprime.model.PropertyType;
import org.imobprime.repository.PropertyTypeRepository;
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
public class PropertyTypeRestController {

	@Autowired
	PropertyTypeRepository repository;
	
	@GetMapping("propertyTypes")
	public ResponseEntity<?> listAll() {
		List<PropertyType> propertyTypes = repository.findAll();
		return new ResponseEntity<>(propertyTypes, HttpStatus.OK);
	}
	
}
