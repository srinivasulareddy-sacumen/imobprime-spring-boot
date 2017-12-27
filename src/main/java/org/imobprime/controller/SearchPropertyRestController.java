package org.imobprime.controller;

import java.util.List;

import org.imobprime.dao.SearchPropertyDAO;
import org.imobprime.model.Property;
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
public class SearchPropertyRestController {

	@Autowired
	SearchPropertyDAO searchPropertyDAO;
	
	@GetMapping("search/properties")
	public ResponseEntity<?> searchMostRecent() {
		List<Property> properties = searchPropertyDAO.findAllMostRecent(null);
		return new ResponseEntity<>(properties, HttpStatus.OK);
	}
	
}
