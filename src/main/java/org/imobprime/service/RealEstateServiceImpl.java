package org.imobprime.service;

import java.util.List;

import org.imobprime.dao.RealEstateDAO;
import org.imobprime.model.RealEstate;
import org.imobprime.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("realEstateService")
public class RealEstateServiceImpl implements RealEstateService {

	@Autowired
	RealEstateRepository realEstateRepository;
	
	@Autowired
	RealEstateDAO realEstateDAO;

	@Override
	public List<RealEstate> findAll() {
		// get the first 25 real estates
//		Pageable pageable = new PageRequest(0, 25);
//		Page<RealEstate> realEstates = realEstateRepository.findAll(pageable);
//		return realEstates.getContent();
		return realEstateDAO.findAll();
	}

	@Override
	public RealEstate findById(Integer id) {
		return realEstateRepository.findOne(id);
	}

	@Override
	@Transactional
	public void save(RealEstate realEstate) {
		realEstateRepository.save(realEstate);
	}

	@Override
	@Transactional
	public void update(RealEstate realEstate) {
		realEstateRepository.save(realEstate);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		realEstateRepository.delete(id);
	}

}
