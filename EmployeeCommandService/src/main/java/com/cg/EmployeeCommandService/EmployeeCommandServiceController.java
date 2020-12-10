package com.cg.EmployeeCommandService;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
@Api(value="EmployeeCommandService demo using logger and swagger")
public class EmployeeCommandServiceController {

	@Autowired
	private EmployeeCommandServiceProxy employeeProxy;
	
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeCommandServiceController.class);
	
	
	
	
	/***************************************add an employee **************************************/
	
	@ApiOperation(value = "createEmployee", nickname = "createEmployee") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Employee.class), 
	@ApiResponse(code = 500, message = "Failure", response = Employee.class)})
	@PostMapping("/addemployee")
	public boolean createEmployee(@RequestBody Employee employee)
	{
		boolean added=employeeProxy.createEmployee(employee);
		if(added)
			return true;
		return false;
	}
	
	
	
	/*************************************** update an employee ********************************/
	@ApiOperation(value = "updateEmployee", nickname = "updateEmployee") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Employee.class), 
	@ApiResponse(code = 500, message = "Failure", response = Employee.class)})
	@PutMapping("/updateemployee")
	public boolean updateEmployee(@RequestBody Employee employee)
	{
		boolean updated=employeeProxy.updateEmployee(employee);
		if(updated)
			return true;
		return false;
	}

	
	/*************************************** delete an employee ********************************/
	@ApiOperation(value = "deleteEmployee", nickname = "deleteEmployee") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Employee.class), 
	@ApiResponse(code = 500, message = "Failure", response = Employee.class)})
	@DeleteMapping("/deleteemployee")
	public boolean deleteEmployee(@RequestParam ("employeeId") int employeeId)
	{
		boolean deleted=employeeProxy.deleteEmployee(employeeId);
		if(deleted)
			return true;
		return false;
	}
	
	
}
