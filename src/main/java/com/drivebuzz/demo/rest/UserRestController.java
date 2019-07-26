package com.drivebuzz.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drivebuzz.demo.entity.User;
import com.drivebuzz.demo.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/user-api")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		
		User theTask = userService.findById(userId);
		
		if (theTask == null) {
			throw new RuntimeException("Task id not found - " + userId);
		}
		
		return theTask;
	}
	
	@PostMapping("/users")
	public User addTask(@RequestBody User theUser) {
		
		theUser.setId(0);
		
		userService.save(theUser);
		
		return theUser;
	}
}
