package org.imobprime.controller;

import java.util.List;

import org.imobprime.model.Property;
import org.imobprime.service.PropertyService;
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
public class PropertyRestController {

	public static final Logger logger = LoggerFactory.getLogger(PropertyRestController.class);

	@Autowired
	PropertyService propertyService;

	@GetMapping("/properties")
	public ResponseEntity<?> listAll() {
		logger.info("Fetching all properties.");
		List<Property> properties = propertyService.findAll();

		if (properties.isEmpty()) {
			logger.info("There is no properties in database.");
			// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(properties, HttpStatus.OK);
	}
	
	@PostMapping("/search-properties")
	public ResponseEntity<?> listAll(@RequestBody PropertySearchDTO propertySearchDTO) {
		logger.info("Fetching all properties by params.");
		List<Property> properties = propertyService.findAll(propertySearchDTO);

		if (properties.isEmpty()) {
			logger.info("There is no properties in database.");
			// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(properties, HttpStatus.OK);
	}
	
}
