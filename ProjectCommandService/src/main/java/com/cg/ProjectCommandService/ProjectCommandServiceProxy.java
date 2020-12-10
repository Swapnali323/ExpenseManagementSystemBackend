package com.cg.ProjectCommandService;

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
public interface ProjectCommandServiceProxy {

	/*******************************************Project specific proxies*******************************/
	
	
	
	@PostMapping("/projectdatabaseproviderservice/addproject")
	public boolean createProject(@RequestBody Project project);
	
	
	@PutMapping("/projectdatabaseproviderservice/updateproject")
	public boolean updateProject(@RequestBody Project project);
	
	@DeleteMapping("/projectdatabaseproviderservice/deleteproject")
	public boolean deleteProject(@RequestParam ("projectCode") int projectCode);
	
	
	
	
}
