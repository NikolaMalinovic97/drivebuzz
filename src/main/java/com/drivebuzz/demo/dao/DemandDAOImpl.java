package com.drivebuzz.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drivebuzz.demo.entity.Demand;

@Repository
public class DemandDAOImpl implements DemandDAO {

	private EntityManager entityManager;
	
	@Autowired
	public DemandDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Demand> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Demand> theQuery =
				currentSession.createQuery("from Demand", Demand.class);
		
		List<Demand> demands = theQuery.getResultList();
		
		return demands;
	}

	@Override
	public List<Demand> findAllActive() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Demand> theQuery =
				currentSession.createQuery("from Demand where active = 1", Demand.class);
		
		List<Demand> activeDemands = theQuery.getResultList();
		
		return activeDemands;
	}

	@Override
	public List<Demand> findAllInactive() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Demand> theQuery =
				currentSession.createQuery("from Demand where active = 0", Demand.class);
		
		List<Demand> inactiveDemands = theQuery.getResultList();
		
		return inactiveDemands;
	}

	@Override
	public Demand findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Demand theDemand = currentSession.get(Demand.class, theId);
		
		return theDemand;
	}

	@Override
	public List<Demand> findDemandsForSpecificUser(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Demand theDemand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
