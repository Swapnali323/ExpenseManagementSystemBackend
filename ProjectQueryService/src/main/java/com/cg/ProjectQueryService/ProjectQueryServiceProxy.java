package com.cg.ProjectQueryService;

/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 
import java.util.List;


import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




/********************************proxy interface that communicates with database provider service*/////////////////////////////////
//@FeignClient(name="projectdatabaseproviderservice")
@FeignClient(name = "zuulserver")
@RibbonClient(name="projectdatabaseproviderservice")
public interface ProjectQueryServiceProxy {

	/*******************************************Project specific proxies*******************************/
	@GetMapping("/projectdatabaseproviderservice/getprojects")
	public @ResponseBody List<Project> getProjects();
	
	
	@GetMapping("/projectdatabaseproviderservice/searchproject")
	public List<Project> searchProject(@RequestParam ("projectCode") int projectCode);
	
	@GetMapping("/projectdatabaseproviderservice/searchprojectdesc")
	public List<Project> searchProjectDesc(@RequestParam ("description") String description);
}
