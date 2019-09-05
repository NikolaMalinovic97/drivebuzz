package com.drivebuzz.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drivebuzz.demo.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<User> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> theQuery =
				currentSession.createQuery("from User", User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;
	}

	@Override
	public User findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		User theUser = currentSession.get(User.class, theId);
		
		return theUser;
	}
	
	@Override
	public User validate(String username, String password) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<User> theQuery =
				currentSession.createQuery("from User where username=:username and password=:password");
		theQuery.setParameter("username", username);
		theQuery.setParameter("password", password);
		
		User theUser;
		
		try {
			theUser = theQuery.getSingleResult();
		} 
		catch (NoResultException e) {
			return null;
		}
		
		return theUser;
	}

	@Override
	public void save(User theUser) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public void deleteById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		User theUser = this.findById(theId);
		int theUserInfoId = theUser.getUserInfo().getId();
		
		Query<?> theQuery = 
				currentSession.createQuery("delete from UserInfo where id=:userInfoId");
		theQuery.setParameter("userInfoId", theUserInfoId);
		
		theQuery.executeUpdate();
	}

}
