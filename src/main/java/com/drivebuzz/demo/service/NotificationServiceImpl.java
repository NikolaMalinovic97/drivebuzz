package com.drivebuzz.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drivebuzz.demo.dao.NotificationDAO;
import com.drivebuzz.demo.entity.Notification;

@Service
public class NotificationServiceImpl implements NotificationService {

	private NotificationDAO notificationDAO;
	
	public NotificationServiceImpl(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}

	@Override
	@Transactional
	public Notification findById(int theId) {
		return notificationDAO.findById(theId);
	}

	@Override
	@Transactional
	public List<Notification> findNotificationsForSpecificUser(int theId) {
		return notificationDAO.findNotificationsForSpecificUser(theId);
	}

	@Override
	@Transactional
	public void save(Notification theNotification) {
		notificationDAO.save(theNotification);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		notificationDAO.deleteById(theId);
	}

}
