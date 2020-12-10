package com.cg.ProjectDatabaseProviderService.ProjectProvider;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*
 * 
 * @Author:prakash devar
 * 
 * Created on 30/4/2020
 */
 

@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RestController

public class ProjectController {

	@Autowired
	private ProjectRepository repository;
	@Autowired
	private Environment env;
	
	@Autowired
	private ProjectServiceImpl service;
	
	 /***************************************retrieve all Projects *///////////////////////
	@GetMapping("/getprojects")
	public @ResponseBody List<Project> getProjects()
	{
		/*
		 * temporary list of Projects
		 */
		List<Project> tempList=new ArrayList<Project>();
		
		//tempList=repository.findAll();
		tempList=service.getProjects();
		return tempList;
	}
	
	
	 /*************************************** create an Project ********************************/
		@PostMapping("/addproject")
		public boolean createProject(@RequestBody Project project)
		{
			boolean added=service.addProject(project);
			if(added)
				return true;
			return false;
		}
		
		
		/*************************************** update an Project ********************************/
		@PutMapping("/updateproject")
		public boolean updateProject(@RequestBody Project project)
		{
			boolean updated=service.updateProject(project);
			if(updated)
				return true;
			return false;
		}
	
		
		/*************************************** delete an Project ********************************/
		@DeleteMapping("/deleteproject")
		public boolean deleteProject(@RequestParam ("projectCode") int projectCode)
		{
			boolean deleted=service.deleteProject(projectCode);
			if(deleted)
				return true;
			return false;
		}
		
		
		/*************************************** search an Project by code********************************/
		@GetMapping("/searchproject")
		public List<Project> searchProject(@RequestParam ("projectCode") int projectCode)
		{
			List<Project> project= service.searchProject(projectCode);
			return project;
		}
		
		/*************************************** search an Project ********************************/
		@GetMapping("/searchprojectdesc")
		public List<Project> searchProjectDesc(@RequestParam ("description") String description)
		{
			List<Project> project= service.searchProjectDesc(description);
			return project;
		}
		
		
}
