package org.imobprime.controller;

import org.imobprime.model.ZipCode;
import org.imobprime.service.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ZipCodeRestController {

	@Autowired
	ZipCodeService zipCodeService;
	
	@GetMapping("zipcodes/{postalCode}")
	public ResponseEntity<ZipCode> getByPostalCode(@PathVariable("postalCode") String postalCode) {		
		ZipCode zipCode = zipCodeService.findByPostalCode(postalCode);
		return new ResponseEntity<>(zipCode, HttpStatus.OK);
	}
	
	@PostMapping("zipcodes")
	public ResponseEntity<ZipCode> save(@RequestBody ZipCode zipCode) {
		zipCodeService.save(zipCode);
		return new ResponseEntity<>(zipCode, HttpStatus.OK);
	}
	
}
