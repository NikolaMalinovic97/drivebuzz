package com.drivebuzz.demo.service;

import java.util.List;

import com.drivebuzz.demo.entity.Notification;

public interface NotificationService {

	public Notification findById(int theId);
	
	public List<Notification> findNotificationsForSpecificUser(int theId);
	
	public void save(Notification theNotification);
	
	public void deleteById(int theId);
	
}
