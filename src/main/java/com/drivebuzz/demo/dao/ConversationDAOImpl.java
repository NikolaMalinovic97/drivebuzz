package com.drivebuzz.demo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drivebuzz.demo.entity.Conversation;

@Repository
public class ConversationDAOImpl implements ConversationDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ConversationDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Conversation findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Conversation theConversation) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theConversation);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
