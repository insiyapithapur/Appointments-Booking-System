package com.training.project.dao.Imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.project.dao.GenericDao;
import com.training.project.model.User;

public class UserDaoImp implements GenericDao<User, Integer> {
	
	private Session session;

	public UserDaoImp(Session session) {
		super();
		this.session = session;
	}
	
	@Override
	public User findById(Integer id) {
		System.out.println("Session in createDoctorByAdmin: id "+id+" " + session);
		Transaction tx = session.beginTransaction();
	    User user = session.get(User.class, id);
	    System.out.println("user "+user);
	    tx.commit();  // Ensure commit happens
	    return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
	    Transaction tx = null;
	    try {
	        tx = session.beginTransaction(); // Start transaction
	        users = session.createQuery("FROM User", User.class).list(); // Fetch all users
	        tx.commit(); // Commit transaction
	    } catch (Exception e) {
	        if (tx != null) tx.rollback(); // Rollback in case of error
	        e.printStackTrace();
	    }
	    System.out.print(users.isEmpty());
	    return users;	}

	@Override
	public boolean create(User user) {
		Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public User findByUsername(String username) {
        try {
            return session.createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
