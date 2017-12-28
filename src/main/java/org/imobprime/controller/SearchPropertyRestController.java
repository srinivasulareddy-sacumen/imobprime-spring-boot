package org.imobprime.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.imobprime.dao.SearchPropertyDAO;
import org.imobprime.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class SearchPropertyRestController {

	@Autowired
	SearchPropertyDAO searchPropertyDAO;
	
	@GetMapping("search/properties")
	public ResponseEntity<?> searchMostRecent(@RequestParam Integer cityId) {
		Map<String, String> parameters = new HashMap<>();
		
		if(cityId == null) {
			parameters.put("cityId", "");
		} else {
			parameters.put("cityId", String.valueOf(cityId));
		}
		
		List<Property> properties = searchPropertyDAO.findAllMostRecent(parameters);
		return new ResponseEntity<>(properties, HttpStatus.OK);
	}
	
}
