package com.training.project.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.training.project.dao.Imp.RoleDaoImp;
import com.training.project.dao.Imp.UserDaoImp;
import com.training.project.model.*;

public class UserService {
	private SessionFactory sessionFactory;
	private UserDaoImp userDao;
	
	public UserService(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Creates a new doctor user after validating that the request is from an admin
	 * and that the username doesn't already exist
	 */
//	public boolean createDoctorByAdmin(int adminId, User doctorUser) {
	public boolean createDoctorByAdmin(Integer adminId) {
	    Session session = sessionFactory.openSession();
	    userDao = new UserDaoImp(session);
	    
	    RoleDaoImp roledao = new RoleDaoImp(session);
    	Role role = roledao.findById(3);
    	User doctorUser = new User("Insiya_Doc3","ROOT",true,role);
    	
	    try {
	    	System.out.println("Session in createDoctorByAdmin: 1 " + session);
	        // 1. Verify the admin ID is valid
	        User adminUser = userDao.findById(adminId);
	        System.out.println("Session in createDoctorByAdmin: 2 " + session);

	        if (adminUser == null) {
	            System.out.println("Admin user not found with ID: " + adminId);
	            return false;
	        }
	        
	        // 2. Verify the user has admin role
	        Role adminRole = adminUser.getRole();
	        if (adminRole == null || !isAdminRole(adminRole)) {
	            System.out.println("User with ID " + adminId + " does not have admin privileges");
	            return false;
	        }
	        
	        // 3. Check if the username already exists
	        User existingUser = userDao.findByUsername(doctorUser.getUsername());
	        if (existingUser != null) {
	            System.out.println("Username '" + doctorUser.getUsername() + "' already exists");
	            return false;
	        }
	        
	        // 5. Create the doctor user
	        boolean result = userDao.create(doctorUser);
	        return result;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	    	System.out.println("Session in createDoctorByAdmin: closing " + session);
	        session.close();
	    }
	}
	
	/*
	 * Registration
	 */
	public boolean createPatient() {
	    Session session = sessionFactory.openSession();
	    userDao = new UserDaoImp(session);
	    
	    RoleDaoImp roledao = new RoleDaoImp(session);
    	Role role = roledao.findById(2);
    	User patientUser = new User("Insiya_Patient1","ROOT",true,role);
    	
	    try {
	        // 1. Check if the username already exists
	        User existingUser = userDao.findByUsername(patientUser.getUsername());
	        if (existingUser != null) {
	            System.out.println("Username '" + patientUser.getUsername() + "' already exists");
	            return false;
	        }
	        
	        // 5. Create the doctor user
	        boolean result = userDao.create(patientUser);
	        return result;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        session.close();
	    }
	}
	
	
	
	public List<User> AllUser() {
	    Session session = sessionFactory.openSession();
	    userDao = new UserDaoImp(session);
	    
	    List<User> users = userDao.findAll(); // Fetch all users
	    System.out.println("kjbfkjsdbf");
	    
	    users.forEach(System.out::println);
	    
	    // Print user details
//	    for (User user : users) {
//	    	System.out.println("kjbfkjsdbf");
//	        System.out.println(user);
//	    }

	    session.close(); // Close the session to prevent memory leaks
	    return users;
	}

	 private boolean isAdminRole(Role role) {
	        return role.getRoleId() == 1;
	    }
}
