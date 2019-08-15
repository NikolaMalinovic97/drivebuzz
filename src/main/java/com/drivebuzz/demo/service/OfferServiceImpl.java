package com.drivebuzz.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drivebuzz.demo.dao.OfferDAO;
import com.drivebuzz.demo.entity.Offer;

@Service
public class OfferServiceImpl implements OfferService {

	private OfferDAO offerDAO;
	
	public OfferServiceImpl(OfferDAO offerDAO) {
		this.offerDAO = offerDAO;
	}

	@Override
	@Transactional
	public List<Offer> findAll() {
		return offerDAO.findAll();
	}

	@Override
	@Transactional
	public List<Offer> findAllActive() {
		return offerDAO.findAllActive();
	}

	@Override
	@Transactional
	public List<Offer> findAllInactive() {
		return offerDAO.findAllInactive();
	}

	@Override
	@Transactional
	public Offer findById(int theId) {
		return offerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Offer theOffer) {
		offerDAO.save(theOffer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		offerDAO.deleteById(theId);
	}

}
