package com.drivebuzz.demo.dao;

import com.drivebuzz.demo.entity.Notification;

public interface NotificationDAO {

	public Notification findById(int theId);
	
	public void save(Notification theNotification);
	
	public void deleteById(int theId);
	
}
