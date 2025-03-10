package com.training.project.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.training.project.dao.UserDao;
import com.training.project.model.User;

public class RegisterService {
	
	SessionFactory  sessionFactory;
	
	public RegisterService(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public boolean create(User user) {
	   
	   Session session =  sessionFactory.openSession();
	   Transaction transaction = session.beginTransaction();
	 
	   Object isSaved = null;
	   UserDao userDao = new UserDao(session);
	   if(userDao.findByUserName(user.getUsername())==null) {
	    isSaved = session.save(user);
	    transaction.commit(); 
	   }
	   session.close();
	    return isSaved != null; 
	}

}
