package com.org.bookservice.securitydao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.org.bookservice.model.RoleEntity;

public class RoleDAOImpl implements RoleDAO {

	public RoleDAOImpl() {
		super();
		
	}

	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addRole(RoleEntity role) {
		this.sessionFactory.getCurrentSession().save(role);
		
	}

}
