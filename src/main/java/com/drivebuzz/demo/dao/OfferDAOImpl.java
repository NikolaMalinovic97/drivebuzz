package com.drivebuzz.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drivebuzz.demo.entity.Offer;

@Repository
public class OfferDAOImpl implements OfferDAO {

	private EntityManager entityManager;
	
	@Autowired
	public OfferDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Offer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> findAllActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> findAllInactive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offer findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> findOffersForSpecificUser(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Offer theOffer) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theOffer);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
