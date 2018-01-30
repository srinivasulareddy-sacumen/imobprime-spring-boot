package org.imobprime.dao;

import java.util.List;

import org.imobprime.controller.PropertySearchDTO;
import org.imobprime.model.Property;

public interface PropertyDAO {

	public List<Property> findAll();

	public List<Property> findAll(PropertySearchDTO clientSearchDTO);

	public Property findOne(Integer id);

}
