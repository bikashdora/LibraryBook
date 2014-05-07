package com.org.bookservice.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.bookservice.model.RoleEntity;
import com.org.bookservice.model.UserEntity;
import com.org.bookservice.securitydao.UserDAO;
@Service
public class UserManagerImpl implements UserManager,UserDetailsService  {

	@Autowired
    private UserDAO userDAO;
	
	@Autowired
	MailService mailer;
	

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public UserManagerImpl() {
		
	}
	@Override
	@Transactional
	public void addUser(UserEntity user) {
		userDAO.addUser(user);        
       // mailer.sendMail("Bikash.Dora@talentica.com", "New User Added", user.toString());
        
		
	}
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity user = userDAO.getUser(username);		
        boolean accountNonExpired = true;  
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = true;  
        return new User(  
        		user.getUserId(),   
        		user.getPassword(),   
                user.isEnabled(),   
                accountNonExpired,   
                credentialsNonExpired,   
                accountNonLocked,  
                getAuthorities(user.getRoles())  
        );	
		
	}
	@SuppressWarnings("unchecked")
	private Collection<? extends GrantedAuthority> getAuthorities(
			Set<RoleEntity> roles) {
		// TODO Auto-generated method stub
		
		return (Collection<? extends GrantedAuthority>) Arrays.asList(roles.toArray());
	}
	

	

}
