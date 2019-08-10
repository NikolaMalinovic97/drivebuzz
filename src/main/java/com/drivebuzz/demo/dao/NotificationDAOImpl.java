package com.drivebuzz.demo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
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
	public void save(Notification theNotification) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theNotification);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<?> theQuery =
				currentSession.createQuery("delete from Notification where id=:notificationId");
		theQuery.setParameter("notificationId", theId);
		
		theQuery.executeUpdate();
	}

}
