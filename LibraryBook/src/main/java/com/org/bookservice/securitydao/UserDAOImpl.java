package com.org.bookservice.securitydao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.org.bookservice.model.UserEntity;

public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {
		super();
		
	}

	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	
	@Override
	public void addUser(UserEntity user) {
		this.sessionFactory.getCurrentSession().save(user);
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UserEntity getUser(String user) {
		// TODO Auto-generated method stub
		   List<UserEntity> userList = new ArrayList<UserEntity>();  
	        Query query = this.sessionFactory.getCurrentSession().createQuery("from users u where u.userid = :user");  
	        query.setParameter("user", user);  
	        userList = query.list();  
	        if (userList.size() > 0)  
	            return userList.get(0);  
	        else  
	            return null;      
	    }  
	

}
