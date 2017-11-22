package org.imobprime.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RealEstateApiController {

	@RequestMapping(value = "/real-estates/", method = RequestMethod.GET)
	public ResponseEntity<List<String>> listAll() {
		//List<User> users = userService.findAllUsers();
		//if (users.isEmpty()) {
		if (true) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<String>>(new ArrayList<>(), HttpStatus.OK);
	}

}
