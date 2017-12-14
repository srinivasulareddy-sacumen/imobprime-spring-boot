package org.imobprime.service;

import org.imobprime.model.ZipCode;

public interface ZipCodeService {

	public ZipCode findByPostalCode(String postalCode);

	public void save(ZipCode zipCode);
	
}
