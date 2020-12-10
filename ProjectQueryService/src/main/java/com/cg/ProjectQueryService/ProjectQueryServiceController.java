package com.cg.ProjectQueryService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ProjectQueryServiceController {

	@Autowired
	private ProjectQueryServiceProxy projectProxy;
	
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectQueryServiceController.class);
	
	
	/***************************************retrieve all projects *///////////////////////
	@HystrixCommand(fallbackMethod = "alternateprojectsList")
	@ApiOperation(value = "getProjects", nickname = "getProjects") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Project.class), 
	@ApiResponse(code = 500, message = "Failure", response = Project.class)})
	@GetMapping(path="/getprojects")
	public List<Project> getProjects()
	{
		List<Project> projectslist=projectProxy.getProjects();
		if (projectslist.size()<1)
		{
			throw new RuntimeException("no projects available");
		}
		return projectslist;
	}
	
	
	/***************************************fall back method for retrieve all projects *///////////////////////
	
	public List<Project> alternateprojectsList()
	{ 
		logger.info("\"Due to Exception, the fallbackmethod for get all projects has been invoked by Hystrix");
		System.out.println("inside alternateMethod"); 
		Date date = new Date();
		List<Project> tempList=new ArrayList<Project>();
		Project proj1=new Project(666,"IFL 2020","2019-02-02","2020-02-02");
		Project proj2=new Project(897,"Mxrs 2019","2015-02-02","2017-02-02");
		tempList.add(proj1);
		tempList.add(proj2);
		return tempList;
	}
	
	
	
	
	/*************************************** search an project by id ********************************/
	@ApiOperation(value = "searchProject", nickname = "searchProject") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Project.class), 
	@ApiResponse(code = 500, message = "Failure", response = Project.class)})
	
	@GetMapping("/searchproject")
	public List<Project> searchProject(@RequestParam("projectCode") int projectCode)
	{
		List<Project> project= projectProxy.searchProject(projectCode);
		return project;
	}
	
	
	/*************************************** search an project by description ********************************/
	@ApiOperation(value = "searchProjectdesc", nickname = "searchProjectdesc") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Project.class), 
	@ApiResponse(code = 500, message = "Failure", response = Project.class)})
	
	@GetMapping("/searchprojectdesc")
	public List<Project> searchProjectdesc(@RequestParam("description") String description)
	{
		List<Project> project= projectProxy.searchProjectDesc(description);
		return project;
	}
}
