package org.imobprime.service.impl;

import java.util.List;
import java.util.Map;

import org.imobprime.dao.RealEstateDAO;
import org.imobprime.model.RealEstate;
import org.imobprime.model.ZipCode;
import org.imobprime.repository.CityRepository;
import org.imobprime.repository.RealEstateRepository;
import org.imobprime.repository.ZipCodeRepository;
import org.imobprime.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("realEstateService")
public class RealEstateServiceImpl implements RealEstateService {

	@Autowired
	RealEstateRepository realEstateRepository;
	@Autowired
	ZipCodeRepository zipCodeRepository;
	@Autowired
	CityRepository cityRepository;
	
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
	public List<RealEstate> findAll(Map<String, String> parameters) {
		return realEstateDAO.findAll(parameters);
	}

	@Override
	public RealEstate findById(Integer id) {
		return realEstateDAO.findOne(id);
	}

	@Override
	@Transactional
	public void save(RealEstate realEstate) {
		ZipCode zipCode = findOrSaveZipCode(realEstate);
		realEstate.setAddressZipCode(zipCode);
		
		realEstateRepository.save(realEstate);
	}

	private ZipCode findOrSaveZipCode(RealEstate realEstate) {
		ZipCode zipCode = null;
		
		// we have to create a new zipCode
		if(realEstate.getAddressZipCode().getId() == null) {
			zipCode = realEstate.getAddressZipCode();
			
			Integer cityId = zipCode.getCity().getId();
			zipCode.setCity(cityRepository.findOne(cityId));
			
			zipCodeRepository.save(zipCode);
		} else {
			zipCode = zipCodeRepository.findOne(realEstate.getAddressZipCode().getId());
		}
		return zipCode;
	}

	@Override
	@Transactional
	public void update(RealEstate realEstate) {
		ZipCode zipCode = findOrSaveZipCode(realEstate);
		realEstate.setAddressZipCode(zipCode);
		
		realEstateRepository.save(realEstate);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		realEstateRepository.delete(id);
	}

}
