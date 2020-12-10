package com.cg.EmployeeQueryService;

import java.util.ArrayList;
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
@Api(value="EmployeeQueryService demo using logger and swagger")
public class EmployeeQueryServiceController {

	@Autowired
	private EmployeeQueryServiceProxy employeeProxy;
	
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeQueryServiceController.class);
	
	
	/***************************************retrieve all employees *///////////////////////
	@HystrixCommand(fallbackMethod = "alternateEmployeesList")
	@ApiOperation(value = "getEmployees", nickname = "getEmployees") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Employee.class), 
	@ApiResponse(code = 500, message = "Failure", response = Employee.class)})
	@GetMapping(path="/getemployees")
	public List<Employee> getEmployees()
	{
		List<Employee> employeeslist=employeeProxy.getEmployees();
		if (employeeslist.size()<1)
		{
			throw new RuntimeException("no employees available");
		}
		return employeeslist;
	}
	
	
	/***************************************fall back method for retrieve all employees *///////////////////////
	
	public List<Employee> alternateEmployeesList()
	{ 
		logger.info("\"Due to Exception, the fallbackmethod for get all employees has been invoked by Hystrix");
		System.out.println("inside alternateMethod"); 
		List<Employee> tempList=new ArrayList<Employee>();
		Employee emp1=new Employee(101,"prakash","AZKP12345","Manager","banking","21-03-2001","15-02-1978",25000.00,"prakashdevar1997@gmail.com",111);
		Employee emp2=new Employee(102,"suresh","PLOH65745","HR","finance","21-10-2017","02-01-1964",34700.00,"sureshdevar1997@gmail.com",112);
		tempList.add(emp1);
		tempList.add(emp2);
		return tempList;
	}
	
	
	
	/*************************************** search an employee by id********************************/
	@ApiOperation(value = "searchEmployee", nickname = "searchEmployee") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Employee.class), 
	@ApiResponse(code = 500, message = "Failure", response = Employee.class)})
	@GetMapping("/searchemployee")
	public List<Employee> searchEmployee(@RequestParam ("employeeId") int employeeId)
	{
		List<Employee> employee= employeeProxy.searchEmployee(employeeId);
		return employee;
	}
	
	
	
	/**********************************get project wise employees list ***************************/
	@ApiOperation(value = "getProjectWiseEmployees", nickname = "getProjectWiseEmployees") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Employee.class), 
	@ApiResponse(code = 500, message = "Failure", response = Employee.class)})
	@GetMapping("/projectwiseemployees")
	public List<Employee> getProjectWiseEmployees(@RequestParam ("projectCode") int projectCode)
	{
		List<Employee> employees= employeeProxy.searchbyProject(projectCode);
		return employees;
	}
	
	/*************************************** search an employee by name********************************/
	@ApiOperation(value = "searchEmployeeName", nickname = "searchEmployeeName") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Employee.class), 
	@ApiResponse(code = 500, message = "Failure", response = Employee.class)})
	@GetMapping("/searchemployeename")
	public List<Employee> searchEmployeeName(@RequestParam ("name") String name)
	{
		List<Employee> employee= employeeProxy.searchEmployeeName(name);
		return employee;
	}
	
	
	
}
