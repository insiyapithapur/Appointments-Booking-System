package com.training.project.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.training.project.dao.Imp.RoleDaoImp;
import com.training.project.model.Role;

public class RoleService {
	private SessionFactory sessionFactory;
	private RoleDaoImp roleDao;
	
	public RoleService(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public boolean create(Role role) {
		final Session session=sessionFactory.openSession();
		roleDao = new RoleDaoImp(session);
		final boolean result=roleDao.create(role);
		session.close();
		return result;
	}
}
