package com.drivebuzz.demo.dao;

import com.drivebuzz.demo.entity.Conversation;

public interface ConversationDAO {

	public Conversation findById(int theId);
	
	public void save(Conversation theConversation);
	
	public void deleteById(int theId);
}
