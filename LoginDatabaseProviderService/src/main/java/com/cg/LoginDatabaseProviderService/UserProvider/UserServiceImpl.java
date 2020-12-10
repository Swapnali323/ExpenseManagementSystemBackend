package com.cg.LoginDatabaseProviderService.UserProvider;

/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 

/*****************************************this class communicates with underlying DAO layer************************************///
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository repository;
	
	public List<User> getUsers()
	{
		return repository.findAll();
	}
	
	
	
	
}




