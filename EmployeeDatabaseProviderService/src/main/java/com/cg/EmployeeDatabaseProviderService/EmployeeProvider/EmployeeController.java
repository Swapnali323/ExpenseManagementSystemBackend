package com.cg.EmployeeDatabaseProviderService.EmployeeProvider;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
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
 * Created on 29/4/2020
 */

 

@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RestController

public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private Environment env;
	
	@Autowired
	private EmployeeServiceImpl service;
	
	 /***************************************retrieve all employees *///////////////////////
	@GetMapping("/getemployees")
	public @ResponseBody List<Employee> getEmployees()
	{
		/*
		 * temporary list of employees
		 */
		List<Employee> tempList=new ArrayList<Employee>();
		
		//tempList=repository.findAll();
		tempList=service.getEmployees();
		return tempList;
	}
	
	
	 /*************************************** create an employee ********************************/
		@PostMapping("/addemployee")
		public boolean createEmployee(@RequestBody Employee employee)
		{
			boolean added=service.addEmployee(employee);
			if(added)
				return true;
			return false;
		}
		
		
		/*************************************** update an employee ********************************/
		@PutMapping("/updateemployee")
		public boolean updateEmployee(@RequestBody Employee employee)
		{
			boolean updated=service.updateEmployee(employee);
			if(updated)
				return true;
			return false;
		}
	
		
		/*************************************** delete an employee ********************************/
		@DeleteMapping("/deleteemployee")
		public boolean deleteEmployee(@RequestParam ("employeeId") int employeeId)
		{
			boolean deleted=service.deleteEmployee(employeeId);
			if(deleted)
				return true;
			return false;
		}
		
		
		/*************************************** search an employee by id ********************************/
		@GetMapping("/searchemployee")
		public List<Employee> searchEmployee(@RequestParam ("employeeId") int employeeId)
		{
			List<Employee> employee= service.searchEmployee(employeeId);
			if(employee.size()==0)
				return null;
			System.out.println("size of result"+employee.size());
			return employee;
		}
		
		/*************************************** get project wise employees ********************************/
		
		@GetMapping("/projectwiseemployees")
		public List<Employee> searchbyProject(@RequestParam ("projectCode") int projectCode)
		{
			
			List<Employee> employees= service.searchProjectWiseEmployees(projectCode);
			return employees;
			
		}
		
		
		/*************************************** search an employee by name ********************************/
		@GetMapping("/searchemployeename")
		public List<Employee> searchEmployeeName(@RequestParam ("name") String name)
		{
			List<Employee> employee= service.searchByName(name);
			return employee;
		}
}
