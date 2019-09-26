package com.drivebuzz.demo.service;

import java.util.List;

import com.drivebuzz.demo.entity.Offer;

public interface OfferService {

	public List<Offer> findAll();
	
	public List<Offer> findAllActive();
	
	public List<Offer> findAllInactive();
	
	public Offer findById(int theId);
	
	public void save(Offer theOffer);
	
	public void deleteById(int theId);

	public List<Offer> findLatestOffersByPage(int pageNumber);
}
