package com.drivebuzz.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drivebuzz.demo.entity.Conversation;
import com.drivebuzz.demo.entity.User;
import com.drivebuzz.demo.service.ConversationService;
import com.drivebuzz.demo.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/conversation-api")
public class ConversationRestController {

	private ConversationService conversationService;
	private UserService userService;
	
	@Autowired
	public ConversationRestController(ConversationService conversationService, UserService userService) {
		this.conversationService = conversationService;
		this.userService = userService;
	}
	
	@GetMapping("/conversations/{conversationsId}")
	public Conversation getConversation(@PathVariable int conversationsId) {
		
		Conversation theConversation = conversationService.findById(conversationsId);
		
		if (theConversation == null) {
			throw new RuntimeException("Conversation id not found - " + conversationsId);
		}
		
		return theConversation;
	}
	
	@GetMapping("/conversations/user/{userId}")
	public List<Conversation> getConversationsForSpecificUser(@PathVariable int userId) {
		
		User theUser = userService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("Specified user does not have any conversations or does not exist.");
		}
		
		return theUser.getConversations();
	}
	
	@PostMapping("/conversations/{userOneId}/{userTwoId}")
	public Conversation addConversation(@PathVariable int userOneId, @PathVariable int userTwoId) {
		
		User userOne = userService.findById(userOneId);
		User userTwo = userService.findById(userTwoId);
		
		Conversation theConversation = new Conversation("2019-08-12", "13:12:00");
		
		theConversation.addUser(userOne);
		theConversation.addUser(userTwo);
		
		theConversation.setId(0);
		
		conversationService.save(theConversation);
		
		return theConversation;
	}
	
	@DeleteMapping("/conversations/{conversationId}")
	public String deleteConversation(@PathVariable int conversationId) {
		
		Conversation theConversation = conversationService.findById(conversationId);
		
		if (theConversation == null) {
			throw new RuntimeException("Conversation id not found - " + conversationId);
		}
		
		conversationService.deleteById(conversationId);
		
		return "Deleted Conversation with id: " + conversationId;
	}
	
}
