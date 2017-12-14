package org.imobprime.service.impl;

import org.imobprime.dao.ZipCodeDAO;
import org.imobprime.model.ZipCode;
import org.imobprime.repository.ZipCodeRepository;
import org.imobprime.service.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {
	
	@Autowired
	ZipCodeDAO zipCodeDAO;
	
	@Autowired
	ZipCodeRepository zipCodeRepository;

	@Override
	public ZipCode findByPostalCode(String postalCode) {
		return zipCodeDAO.findOne(postalCode);
	}

	@Override
	@Transactional
	public void save(ZipCode zipCode) {
		zipCodeRepository.save(zipCode);
	}

}
