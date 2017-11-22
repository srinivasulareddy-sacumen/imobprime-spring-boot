package org.imobprime.controller;

import java.util.List;

import org.imobprime.model.RealEstate;
import org.imobprime.service.RealEstateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RealEstateRestController {

	public static final Logger logger = LoggerFactory.getLogger(RealEstateRestController.class);
	
	@Autowired
	RealEstateService realEstateService;
	
	@RequestMapping(value = "/real-estates/", method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {
		logger.info("Fetching all real estates.");
		List<RealEstate> realEstates = realEstateService.findAll();
		
		if (realEstates.isEmpty()) {
			logger.info("There is no real estates in database.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(realEstates, HttpStatus.OK);
	}

}
