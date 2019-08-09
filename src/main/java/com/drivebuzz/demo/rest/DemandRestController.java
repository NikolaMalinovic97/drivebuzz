package com.drivebuzz.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drivebuzz.demo.entity.Demand;
import com.drivebuzz.demo.entity.Offer;
import com.drivebuzz.demo.service.DemandService;
import com.drivebuzz.demo.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/demand-api")
public class DemandRestController {

	private DemandService demandService;
	private UserService userService;
	
	@Autowired
	public DemandRestController(DemandService demandService, UserService userService) {
		this.demandService = demandService;
		this.userService = userService;
	}
	
	@GetMapping("/demands")
	public List<Demand> findAll() {
		
		return demandService.findAll();
	}
	
	@GetMapping("/demands/active")
	public List<Demand> findAllActive() {
		
		return demandService.findAllActive();
	}
	
	@GetMapping("/demands/inactive")
	public List<Demand> findAllInactive() {
		
		return demandService.findAllInactive();
	}
	
	@GetMapping("/demands/{demandId}")
	public Demand getDemand(@PathVariable int demandId) {
		
		Demand theDemand = demandService.findById(demandId);
		
		if (theDemand == null) {
			throw new RuntimeException("Demand id not found - " + demandId);
		}
		
		return theDemand;
	}
	
	@GetMapping("/demands/user/{userId}")
	public List<Demand> getDemandsForSpecificUser(@PathVariable int userId) {
		
		List<Demand> demands = demandService.findDemandsForSpecificUser(userId);
		
		if (demands.isEmpty()) {
			throw new RuntimeException("Specified user does not have any demands or does not exist.");
		}
		
		return demands;
	}
	
}
