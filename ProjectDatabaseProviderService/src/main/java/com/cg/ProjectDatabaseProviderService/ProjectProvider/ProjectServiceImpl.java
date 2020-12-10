package com.cg.ProjectDatabaseProviderService.ProjectProvider;

/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 

/*****************************************this class communicates with underlying DAO layer************************************///
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl {

	@Autowired
	private ProjectRepository repository;
	
	public List<Project> getProjects()
	{
		return repository.findAll();
	}
	
	public Boolean updateProject(Project project)
	{
		
		repository.save(project);
		return true;
	}
	
	
	public Boolean deleteProject(int projectid)
	{
		
		repository.deleteById(projectid);
		return true;
	}
	
	public Boolean addProject(Project project)
	{
		
		repository.save(project);
		return true;
	}
	
	
	public List<Project> searchProject(int projectCode)
	{
		
		List<Project> project= repository.findByprojectCode(projectCode);
		return project;
		
	}
	
	public List<Project> searchProjectDesc(String description)
	{
		
		List<Project> project= repository.searchbyDescription(description);
		return project;
		
	}
	
	
	
}




