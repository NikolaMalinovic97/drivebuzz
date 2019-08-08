package com.drivebuzz.demo.service;

import java.util.List;

import com.drivebuzz.demo.entity.Demand;

public interface DemandService {

	public List<Demand> findAll();
	
	public List<Demand> findAllActive();
	
	public List<Demand> findAllInactive();
	
	public Demand findById(int theId);
	
	public List<Demand> findDemandsForSpecificUser(int theId);
	
	public void save(Demand theDemand);
	
	public void deleteById(int theId);
}
