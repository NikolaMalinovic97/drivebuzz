package com.drivebuzz.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}