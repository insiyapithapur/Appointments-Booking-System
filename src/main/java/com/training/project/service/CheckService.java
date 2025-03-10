package com.training.project.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.training.project.dao.UserDao;
import com.training.project.model.User;

public class CheckService {
	SessionFactory sessionFactory;

	public CheckService(SessionFactory sessionFactory) {
		
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean checkUser(String username) {
		Session session = sessionFactory.openSession();
		UserDao userDao = new UserDao(session);
		User user =  userDao.findByUserName(username);
		session.close();
		return user != null;
	}
	public boolean checkPassword(String username,String password) {
		Session session = sessionFactory.openSession();
		UserDao userDao = new UserDao(session);
		
		User user =  userDao.findToAuthenticate(username);
		String dbPassword = user.getPassword();
		//decrypt logic
		String decryptedPassword = dbPassword;
		session.close();
		return decryptedPassword.equals(password);
	}
}
