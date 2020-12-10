package com.cg.ProjectCommandService;

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
@Api(value="ProjectCommandService demo using logger and swagger")
public class ProjectCommandServiceController {

	@Autowired
	private ProjectCommandServiceProxy projectProxy;
	
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectCommandServiceController.class);
	
	
	
	
	/***************************************add an project **************************************/
	
	@ApiOperation(value = "createProject", nickname = "createProject") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Project.class), 
	@ApiResponse(code = 500, message = "Failure", response = Project.class)})
	@PostMapping("/addproject")
	public boolean createProject(@RequestBody Project project)
	{
		boolean added=projectProxy.createProject(project);
		if(added)
			return true;
		return false;
	}
	
	
	
	/*************************************** update an project ********************************/
	@ApiOperation(value = "updateProject", nickname = "updateProject") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Project.class), 
	@ApiResponse(code = 500, message = "Failure", response = Project.class)})
	@PutMapping("/updateproject")
	public boolean updateProject(@RequestBody Project project)
	{
		boolean updated=projectProxy.updateProject(project);
		if(updated)
			return true;
		return false;
	}

	
	/*************************************** delete an project ********************************/
	@ApiOperation(value = "deleteProject", nickname = "deleteProject") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Project.class), 
	@ApiResponse(code = 500, message = "Failure", response = Project.class)})
	@DeleteMapping("/deleteproject")
	public boolean deleteProject(@RequestParam ("projectCode") int projectCode)
	{
		boolean deleted=projectProxy.deleteProject(projectCode);
		if(deleted)
			return true;
		return false;
	}
	
	

}
