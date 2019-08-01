package com.drivebuzz.demo.dao;

import java.util.List;

import com.drivebuzz.demo.entity.Offer;

public interface OfferDAO {

	public List<Offer> findAll();
	
	public List<Offer> findAllActive();
	
	public List<Offer> findAllInactive();
	
	public Offer findById(int theId);
	
	public List<Offer> findOffersForSpecificUser(int theId);
	
	public void save(Offer theOffer);
	
	public void deleteById(int theId);
}