package com.drivebuzz.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drivebuzz.demo.entity.Offer;
import com.drivebuzz.demo.service.UserService;

@Repository
public class OfferDAOImpl implements OfferDAO {

	private EntityManager entityManager;
	
	@Autowired
	public OfferDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Offer> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Offer> theQuery =
				currentSession.createQuery("from Offer", Offer.class);
		
		List<Offer> offers = theQuery.getResultList();
		
		return offers;
	}

	@Override
	public List<Offer> findAllActive() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Offer> theQuery =
				currentSession.createQuery("from Offer where active = 1", Offer.class);
		
		List<Offer> activeOffers = theQuery.getResultList();
		
		return activeOffers;
	}

	@Override
	public List<Offer> findAllInactive() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Offer> theQuery =
				currentSession.createQuery("from Offer where active = 0", Offer.class);
		
		List<Offer> inactiveOffers = theQuery.getResultList();
		
		return inactiveOffers;
	}

	@Override
	public Offer findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Offer theOffer = currentSession.get(Offer.class, theId);
		
		return theOffer;
	}

	@Override
	public List<Offer> findOffersForSpecificUser(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery =
				currentSession.createQuery("from Offer where user_id = :userId");
		theQuery.setParameter("userId", theId);
		
		List<Offer> offers = theQuery.getResultList();
				
		return offers;
	}

	@Override
	public void save(Offer theOffer) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theOffer);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<?> theQuery =
				currentSession.createQuery("delete from Offer where id=:offerId");
		theQuery.setParameter("offerId", theId);
		
		theQuery.executeUpdate();
	}

}
