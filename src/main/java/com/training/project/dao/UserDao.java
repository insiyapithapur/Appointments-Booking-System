package com.training.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.project.model.User;

public class UserDao implements IDao<User> {
	Session session;
	User user;
	public UserDao(Session session) {
		super();
		this.session = session;
	}
	
	//Basic crud
	@Override
	public List<User> findAll() { 
		return  session.createQuery(" from users", User.class ).list();
	}
	@Override
	public User findByPk(int id) {
		return session.get(User.class, id);
	}

	@Override
	public boolean create(User user) {
		Transaction transaction = session.beginTransaction();
		Object result = session.save(user);
		transaction.commit();
		return result != null;
	}
	@Override
	public boolean delete(int id) {
		
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, id);
		if(user !=null) {
			session.delete(user);
		}
		transaction.commit();
		return false;
	}
	@Override
	public boolean update(int id, User updatedUser) {
	    Transaction transaction = null;
	    try {
	        transaction = session.beginTransaction();
	        User user = session.get(User.class, id);
	        
	        if (user != null) {
	            user.setUsername(updatedUser.getUsername());
	            user.setPassword(updatedUser.getPassword());
	            user.setIsLogin(updatedUser.getIsLogin());
	            user.setLastLogin(updatedUser.getLastLogin());
	            session.update(user);
	            transaction.commit();
	            return true;
	        }
	    } catch (HibernateException e) {
	        if (transaction != null) transaction.rollback();
	        System.err.println("Error updating user: " + e.getMessage());
	    } finally {
	        session.close();
	    }
	    return false;
	}


	
	//UserDao specific methods
	public User findByUserName(String name) {
	    String hql = "FROM User WHERE username = :name";
	    User user =  session.createQuery(hql, User.class)
	                  .setParameter("name", name)
	                  .uniqueResult();
	    
	    User returnUser = new User();
	    if(user != null) {
	    returnUser.setUserId(user.getUserId());
	    returnUser.setUsername(user.getUsername());
	    returnUser.setIsLogin(user.getIsLogin());
	    returnUser.setLastLogin(user.getLastLogin());
	    return returnUser;
	    }
	    return user;
	   
	}
	
	public User findToAuthenticate(String name) {
	    String hql = "FROM User WHERE username = :name";
	    User user =  session.createQuery(hql, User.class)
	                  .setParameter("name", name)
	                  .uniqueResult();
	    if(user != null) {
	    User returnUser = new User();
	    returnUser.setUserId(user.getUserId());
	    returnUser.setUsername(user.getUsername());
	    returnUser.setPassword(user.getPassword());
	    }
	    return user;
	}
}
