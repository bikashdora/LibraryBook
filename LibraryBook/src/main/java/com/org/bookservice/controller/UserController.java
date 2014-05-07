package com.org.bookservice.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.bookservice.model.RoleEntity;
import com.org.bookservice.model.UserEntity;
import com.org.bookservice.services.UserManager;
import com.org.bookservice.utils.UserRestURIConstants;


/**
 * BooksController class
 */
@Controller
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserManager userManager;
	 public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	 @RequestMapping(value = UserRestURIConstants.CREATE_USER,method = RequestMethod.POST)
		public  ModelAndView  createUser(@Valid UserEntity user, BindingResult result,@RequestParam("userlevel") String[] userlevel,Model m) {
			logger.info("Start addUser");
			ModelAndView modelAndView = new ModelAndView();
			if(result.hasErrors())
			{
				
				  modelAndView.setViewName("register");
				  modelAndView.addObject("user",user);
				  modelAndView.addObject("error","Registration Failed");
				  return modelAndView;		
			}

			else
			{
				Set<RoleEntity> roles = new HashSet<RoleEntity>();
				for(String str:userlevel)
					roles.add(new RoleEntity(str));
				user.setRoles(roles);
				user.setEnabled(true);
				userManager.addUser(user);
			    modelAndView.setViewName("register");
				modelAndView.addObject("user",user);
				modelAndView.addObject("success","Addition Success");
					
			}
			  return modelAndView;	
			
		}
}