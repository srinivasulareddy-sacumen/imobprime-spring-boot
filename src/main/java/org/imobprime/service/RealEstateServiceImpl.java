package org.imobprime.service;

import java.util.ArrayList;
import java.util.List;

import org.imobprime.model.RealEstate;
import org.springframework.stereotype.Service;

@Service("realEstateService")
public class RealEstateServiceImpl implements RealEstateService {

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
		RealEstate r1 = new RealEstate();
		r1.setId(1);
		r1.setName("IBagy");
		
		List list = new ArrayList<RealEstate>();
		list.add(r1);
		return list;
	}

	@Override
	public boolean exists(RealEstate realEstate) {
		// TODO Auto-generated method stub
		return false;
	}

}
