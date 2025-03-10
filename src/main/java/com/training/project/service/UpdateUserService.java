package com.training.project.service;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.training.project.dao.UserDao;
import com.training.project.model.User;

public class UpdateUserService {
	
	SessionFactory sessionFactory;
	Session session;
	
	public UpdateUserService(SessionFactory sesionFactory) {
		super();
		this.sessionFactory = sesionFactory;
	}
	
	public boolean resetPassword(String username, String oldPassword,String newPassword) {
	    Session session = sessionFactory.openSession();
	    boolean result = false;
	    UserDao userDao = new UserDao(session);
	    User user = userDao.findToAuthenticate(username);

	    if(user != null&&user.getUsername().equals(username)) {
	    	if(oldPassword.equals(user.getPassword())) {
	    		user.setPassword(newPassword);
		        userDao.update(user.getUserId(), user);
		        result = true;
	    	}
        }
	    
	    session.close();
	    return result;
	}

//	public boolean changeUsername(String username) {
//		
//		return false;
//	}
	public boolean updateIsLogin(String username,Integer isLogin) {
		Session session = sessionFactory.openSession();
	    boolean result = false;
	    UserDao userDao = new UserDao(session);
	    User user = userDao.findByUserName(username);
	    
	    if(user.getUsername() != null) {
	    		user.setIsLogin(isLogin);
		        userDao.update(user.getUserId(), user);
		        result = true;
	    }
        session.close();
	    return result;
		
	}
	public boolean updateLastLogin(String username,LocalDate logindate) {
		Session session = sessionFactory.openSession();
	    boolean result = false;
	    UserDao userDao = new UserDao(session);
	    User user = userDao.findByUserName(username);
	    
	    if(user.getUsername() != null) {
	    		user.setLastLogin(logindate);
		        userDao.update(user.getUserId(), user);
		        result = true;
	    }
        session.close();
	    return result;
	}
	
}
