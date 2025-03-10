package com.training.project;

import org.hibernate.SessionFactory;
import com.training.project.model.Role;
import com.training.project.service.RoleService;
import com.training.project.util.HibernateUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //ifgwufgwugu
        try {
            // Load Hibernate session factory
        	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

        	RoleService roleService = new RoleService(sessionFactory);
        	
        	Role r1=new Role("Admin");
        	createdRole(roleService, r1);
        	
        	Role r2=new Role("Patient");
        	createdRole(roleService, r2);
        	
        	Role r3=new Role("Doctor");
        	createdRole(roleService, r3);
        	
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to Oracle!");
        }
        
    }
    
    private static void createdRole(RoleService roleService, Role r) {
		boolean isCreated=roleService.create(r);
        if(isCreated) {
        	System.out.println(r+" added to record");
        }
        else {
        	System.out.println("Failed to added");
        }
	}
}
