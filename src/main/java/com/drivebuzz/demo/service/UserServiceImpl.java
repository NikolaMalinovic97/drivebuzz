package com.drivebuzz.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drivebuzz.demo.dao.UserDAO;
import com.drivebuzz.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public User findById(int theId) {
		return userDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(User theUser) {
		userDAO.save(theUser);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		userDAO.deleteById(theId);
	}

}
