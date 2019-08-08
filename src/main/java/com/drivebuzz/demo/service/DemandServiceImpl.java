package com.drivebuzz.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drivebuzz.demo.dao.DemandDAO;
import com.drivebuzz.demo.entity.Demand;

@Service
public class DemandServiceImpl implements DemandService {

	private DemandDAO demandDAO;
	
	public DemandServiceImpl(DemandDAO demandDAO) {
		this.demandDAO = demandDAO;
	}

	@Override
	@Transactional
	public List<Demand> findAll() {
		return demandDAO.findAll();
	}

	@Override
	@Transactional
	public List<Demand> findAllActive() {
		return demandDAO.findAllActive();
	}

	@Override
	@Transactional
	public List<Demand> findAllInactive() {
		return demandDAO.findAllInactive();
	}

	@Override
	@Transactional
	public Demand findById(int theId) {
		return demandDAO.findById(theId);
	}

	@Override
	@Transactional
	public List<Demand> findDemandsForSpecificUser(int theId) {
		return demandDAO.findDemandsForSpecificUser(theId);
	}

	@Override
	@Transactional
	public void save(Demand theDemand) {
		demandDAO.save(theDemand);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		demandDAO.deleteById(theId);
	}

	
}
