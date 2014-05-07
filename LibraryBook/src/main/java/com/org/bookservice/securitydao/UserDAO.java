package com.org.bookservice.securitydao;

import com.org.bookservice.model.UserEntity;

public interface UserDAO {
	
	public void addUser(UserEntity user);
	public UserEntity getUser(String user);
	

}
