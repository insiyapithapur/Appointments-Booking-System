package com.training.project.util;



import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.training.project.model.Role;
import com.training.project.model.User;

public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		
		try {
			return new Configuration().configure("hibernate.cfg.xml")
									  .addAnnotatedClass(User.class)
									  .addAnnotatedClass(Role.class)
									  .buildSessionFactory();
		} catch (HibernateException e) {		
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
}
