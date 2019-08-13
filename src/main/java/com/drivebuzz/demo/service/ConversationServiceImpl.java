package com.drivebuzz.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drivebuzz.demo.dao.ConversationDAO;
import com.drivebuzz.demo.entity.Conversation;

@Service
public class ConversationServiceImpl implements ConversationService {

	private ConversationDAO conversationDAO;
	
	public ConversationServiceImpl(ConversationDAO conversationDAO) {
		this.conversationDAO = conversationDAO;
	}

	@Override
	@Transactional
	public Conversation findById(int theId) {
		return conversationDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Conversation theConversation) {
		conversationDAO.save(theConversation);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		conversationDAO.deleteById(theId);
	}

}
