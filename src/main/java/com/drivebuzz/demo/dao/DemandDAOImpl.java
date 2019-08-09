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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Demand> findAllInactive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Demand findById(int theId) {
		// TODO Auto-generated method stub
		return null;
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
