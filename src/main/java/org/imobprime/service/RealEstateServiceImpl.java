package org.imobprime.service;

import java.util.List;

import org.imobprime.model.RealEstate;
import org.imobprime.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("realEstateService")
public class RealEstateServiceImpl implements RealEstateService {

	@Autowired
    RealEstateRepository realEstateRepository;
	
	@Override
	public RealEstate findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RealEstate findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(RealEstate realEstate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RealEstate realEstate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RealEstate> findAll() {
		Pageable pageable = new PageRequest(0, 25);
		return realEstateRepository.findAll(pageable).getContent();
	}

	@Override
	public boolean exists(RealEstate realEstate) {
		// TODO Auto-generated method stub
		return false;
	}

}
