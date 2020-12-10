package com.cg.EmployeeQueryService;

/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 
import java.util.List;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




/********************************proxy interface that communicates with database provider service*/////////////////////////////////
//@FeignClient(name="employeedatabaseproviderservice")
@FeignClient(name="zuulserver")
@RibbonClient(name="employeedatabaseproviderservice")

public interface EmployeeQueryServiceProxy {

	/*******************************************Employee specific proxies*******************************/
	@GetMapping("/employeedatabaseproviderservice/getemployees")
	public @ResponseBody List<Employee> getEmployees();
	
	
	@GetMapping("/employeedatabaseproviderservice/searchemployee")
	public List<Employee> searchEmployee(@RequestParam ("employeeId") int employeeId);
	
	@GetMapping("/employeedatabaseproviderservice/projectwiseemployees")
	public List<Employee> searchbyProject(@RequestParam ("projectCode") int projectCode);
	
	@GetMapping("/employeedatabaseproviderservice/searchemployeename")
	public List<Employee> searchEmployeeName(@RequestParam ("name") String name);
}
