package com.drivebuzz.demo.dao;

import java.util.List;

import com.drivebuzz.demo.entity.Demand;

public interface DemandDAO {

	public List<Demand> findAll();
	
	public List<Demand> findAllActive();
	
	public List<Demand> findAllInactive();
	
	public Demand findById(int theId);
	
	public void save(Demand theDemand);
	
	public void deleteById(int theId);	
}
