package com.drivebuzz.demo.service;

import com.drivebuzz.demo.entity.Conversation;

public interface ConversationService {
	
	public Conversation findById(int theId);
	
	public void save(Conversation theConversation);
	
	public void deleteById(int theId);
}
