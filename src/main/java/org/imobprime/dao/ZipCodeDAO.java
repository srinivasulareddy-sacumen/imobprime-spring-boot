package org.imobprime.dao;

import org.imobprime.model.ZipCode;

public interface ZipCodeDAO {

	public ZipCode findOne(String postalCode);
	
}
