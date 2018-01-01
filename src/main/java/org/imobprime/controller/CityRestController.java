package org.imobprime.controller;

import java.util.List;

import org.imobprime.model.City;
import org.imobprime.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CityRestController {

	public static final Logger logger = LoggerFactory.getLogger(CityRestController.class);
	
	@Autowired
	CityService cityService;
	
	@GetMapping("cities")
	public ResponseEntity<?> listAll() {
		logger.info("Fetching all cities.");
		List<City> cities = cityService.findAll();
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}
	
	@GetMapping("cities/filter")
	public ResponseEntity<?> filter(
			@RequestParam String name, 
			@RequestParam Integer stateId) {
		logger.info("Fetching cities filtering by name and stateId.");
		
		List<City> cities = cityService.findAll(name, stateId);
		
		if (cities.isEmpty()) {
			logger.info("There is no cities in database with the filter.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}
	
	@GetMapping("cities/{cityName}/{stateAbbreviation}")
	public ResponseEntity<City> getByNameAndStateAbbreviation(
			@PathVariable("cityName") String cityName, @PathVariable("stateAbbreviation") String stateAbbreviation) {
		logger.info("Fetching city by cityName and stateAbbreviation.");
		City city = cityService.findByNameAndStateAbbreviation(cityName, stateAbbreviation);
		logger.info("City fetched with sucess.");

		return new ResponseEntity<>(city, HttpStatus.OK);
	}
	
	@GetMapping("cities/filterByName")
	public ResponseEntity<?> listAllByName(@RequestParam("cityName") String cityName) {
		logger.info("Fetching all cities by name.");
		List<City> cities = cityService.findAll(cityName);
		
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}
	
	@GetMapping("cities/{id}")
	public ResponseEntity<City> getById(@PathVariable("id") Integer id) {
		logger.info("Fetching city by id.");
		City city = cityService.findById(id);
		logger.info("City fetched with sucess.");
		
		return new ResponseEntity<>(city, HttpStatus.OK);
	}
		
}
