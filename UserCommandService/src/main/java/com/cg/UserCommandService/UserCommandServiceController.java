package com.cg.UserCommandService;

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
@Api(value="UserCommandService demo using logger and swagger")
public class UserCommandServiceController {

	@Autowired
	private UserCommandServiceProxy userProxy;
	
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(UserCommandServiceController.class);
	
	
	
	 /*************************************** create an user ********************************/
	@ApiOperation(value = "createUser", nickname ="createUser") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class), 
	@ApiResponse(code = 500, message = "Failure", response = User.class)})
	@PostMapping("/adduser")
	public boolean createUser(@RequestBody User user)
	{
		Boolean created=userProxy.createUser(user);
		if(created)
			return true;
		return false;
	}
	
	
	
	/*************************************** update an user ********************************/
	@ApiOperation(value = "updateUser", nickname ="updateUser") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class), 
	@ApiResponse(code = 500, message = "Failure", response = User.class)})
	@PutMapping("/updateuser")
	public boolean updateUser(@RequestBody User user)
	{
		Boolean updated=userProxy.updateUser(user);
		if(updated)
			return true;
		return false;
	}
	
}
