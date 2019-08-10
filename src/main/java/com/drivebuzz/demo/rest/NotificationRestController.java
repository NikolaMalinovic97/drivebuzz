package com.drivebuzz.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drivebuzz.demo.entity.Notification;
import com.drivebuzz.demo.entity.User;
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
	
	@GetMapping("/notifications/{notificationId}")
	public Notification getNotification(@PathVariable int notificationId) {
		
		Notification theNotification = notificationService.findById(notificationId);
		
		if (theNotification == null) {
			throw new RuntimeException("Notification id not found - " + notificationId);
		}
		
		return theNotification;				
	}
	
	@GetMapping("/notifications/user/{userId}")
	public List<Notification> getNotificationsForSpecificUser(@PathVariable int userId) {
		
		User theUser = userService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		return theUser.getNotifications();
	}
	
}
