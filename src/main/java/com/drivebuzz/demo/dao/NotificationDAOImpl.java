package com.drivebuzz.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drivebuzz.demo.entity.Notification;

@Repository
public class NotificationDAOImpl implements NotificationDAO {

	private EntityManager entityManager;
	
	@Autowired
	public NotificationDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Notification findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Notification theNotification = currentSession.get(Notification.class, theId);
		
		return theNotification;
	}

	@Override
	public List<Notification> findNotificationsForSpecificUser(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Notification theNotification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
