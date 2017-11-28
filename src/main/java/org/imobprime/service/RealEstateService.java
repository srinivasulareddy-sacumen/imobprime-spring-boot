package org.imobprime.service;

import java.util.List;

import org.imobprime.model.RealEstate;

public interface RealEstateService {

	RealEstate findById(Integer id);

	void save(RealEstate realEstate);

	void update(RealEstate realEstate);

	void deleteById(Integer id);

	List<RealEstate> findAll();

}
