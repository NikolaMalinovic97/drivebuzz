package com.drivebuzz.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drivebuzz.demo.service.NotificationService;
import com.drivebuzz.demo.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/notification-api")
public class NotificationRestController {

	private NotificationService notificationService;
	private UserService userService;
	
	@Autowired
	public NotificationRestController(NotificationService notificationService, UserService userService) {
		this.notificationService = notificationService;
		this.userService = userService;
	}
	
}
