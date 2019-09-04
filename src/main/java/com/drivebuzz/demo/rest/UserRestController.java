package com.drivebuzz.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drivebuzz.demo.entity.User;
import com.drivebuzz.demo.extractor.FieldExtractor;
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
		
		User theUser = userService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		return theUser;
	}
	
	@GetMapping("/users/validate")
	public void validateUser(@RequestBody Object object) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		FieldExtractor fieldExtractor = new FieldExtractor();
		
		String username = fieldExtractor.extractUsername(object);
		String password = fieldExtractor.extractPassword(object);
		
		System.out.println(username);
		System.out.println(password);
		
//		TO-DO: add code for validating username and password
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
		
		theUser.setId(0);
		
		userService.save(theUser);
		
		return theUser;
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		
		int userId = theUser.getId();
		theUser.getUserInfo().setId(userId);
		
		userService.save(theUser);
		
		return theUser;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		
		User theUser = userService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted user with id: " + userId;
	}
	
}
