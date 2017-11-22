package org.imobprime.service;

import java.util.List;

import org.imobprime.model.RealEstate;

public interface RealEstateService {

	RealEstate findById(Integer id);
    
    RealEstate findByName(String name);
     
    void save(RealEstate realEstate);
     
    void update(RealEstate realEstate);
     
    void deleteById(Integer id);
 
    List<RealEstate> findAll(); 
     
    public boolean exists(RealEstate realEstate);
	
}
