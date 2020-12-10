package com.cg.EmployeeCommandService;

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
//@FeignClient(name="employeedatabaseproviderservice")
@FeignClient(name="zuulserver")
@RibbonClient(name="employeedatabaseproviderservice")
public interface EmployeeCommandServiceProxy {

	/*******************************************Employee specific proxies*******************************/
	
	
	@PostMapping("/employeedatabaseproviderservice/addemployee")
	public boolean createEmployee(@RequestBody Employee employee);
	
	
	@PutMapping("/employeedatabaseproviderservice/updateemployee")
	public boolean updateEmployee(@RequestBody Employee employee);
	
	@DeleteMapping("/employeedatabaseproviderservice/deleteemployee")
	public boolean deleteEmployee(@RequestParam ("employeeId") int employeeId);
	
	
	
	
	
	
}
