package com.cg.ProjectDatabaseProviderService.ProjectProvider;
/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import feign.Param;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

	
	
	//public Employee findByuserNameAndPassword(@Param("uname") String userName,@Param("pass") String password);
	
	
	public List<Project> findByprojectCode(int projectCode);
	
	@Query(value = "select project from Project project where project.description like %?1%")
	public List<Project> searchbyDescription(String description);
	
}
