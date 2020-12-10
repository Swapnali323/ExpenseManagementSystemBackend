package com.cg.LoginDatabaseProviderService.UserProvider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 

@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RestController

public class UserController {

	@Autowired
	private UserRepository repository;
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserServiceImpl service;
	
	 /***************************************retrieve all users *///////////////////////
	@GetMapping("/getusers")
	public @ResponseBody List<User> getUsers()
	{
		/*
		 * temporary list of users
		 */
		List<User> tempList=new ArrayList<User>();
		
		//tempList=repository.findAll();
	tempList=service.getUsers();
		return tempList;
	}
	
	
	 /***************************************validate user *///////////////////////
	@PostMapping("/login/username/{uname}/password/{pass}")
	public User validateUser(@PathVariable ("uname")String uname,@PathVariable("pass") String pass)
	{
		System.out.println("inside login provider validate controller");
		User user=repository.findByuserNameAndPassword(uname, pass);
		return user;
	}
	
	
	 /*************************************** create an user ********************************/
		@PostMapping("/adduser")
		public boolean createUser(@RequestBody User user)
		{
			
			User newuser=repository.save(user);
			if(newuser!=null)
				return true;
			return false;
		}
		
		
		/*************************************** update an user ********************************/
		@PutMapping("/updateuser")
		public boolean updateUser(@RequestBody User user)
		{
			User updateduser=repository.save(user);
			if(updateduser!=null)
				return true;
			return false;
		}
	
}
