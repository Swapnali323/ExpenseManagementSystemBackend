package com.cg.UserQueryService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 
@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RestController
@Api(value="UserQueryService demo using logger and swagger")
public class UserQueryServiceController {

	@Autowired
	private UserQueryServiceProxy userProxy;
	
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(UserQueryServiceController.class);
	
	
	/***************************************retrieve all users *///////////////////////
	@HystrixCommand(fallbackMethod = "alternateUserList")
	@ApiOperation(value = "getUsers", nickname = "getUsers") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class), 
	@ApiResponse(code = 500, message = "Failure", response = User.class)})
	@GetMapping(path="/getusers")
	public List<User> getUsers()
	{
		List<User> usersList=userProxy.getUsers();
		if (usersList.size()<1)
		{
			throw new RuntimeException("no users available");
		}
		return usersList;
	}
	
	
	/***************************************fall back method for retrieve all users *///////////////////////
	
	public List<User> alternateUserList()
	{ 
		logger.info("\"Due to Exception, the fallbackmethod for get all users has been invoked by Hystrix");
		System.out.println("inside alternateMethod"); 
		List<User> tempList=new ArrayList<User>();
		User user1=new User(6000,"temporary","admin","temporary");
		User user2=new User(7000,"temporary","employee","temporary");
		
		tempList.add(user1);
		tempList.add(user2);
		return tempList;
	}
	
	
	/***************************************check user credentials **************************************/
	

	@ApiOperation(value = "validateUser", nickname = "validateUser") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class), 
	@ApiResponse(code = 500, message = "Failure", response = User.class)})
	@PostMapping(path="/login")
	public User validateuser(@RequestBody User user)
	{
		System.out.println("inside user query validate controller");
		String uname=user.getUserName();
		String pass=user.getPassword();
		User u=userProxy.validateUser(user.getUserName(), user.getPassword());
		if(u==null)
			return null;
		return u;
		
	}
	
	
	
}
