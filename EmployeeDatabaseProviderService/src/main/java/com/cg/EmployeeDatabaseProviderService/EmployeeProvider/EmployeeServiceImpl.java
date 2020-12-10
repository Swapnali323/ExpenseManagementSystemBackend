package com.cg.EmployeeDatabaseProviderService.EmployeeProvider;

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
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getEmployees()
	{
		System.out.println("inside employee checker dbbbbbbbbbbbbbbbbbbb");
		return repository.findAll();
	}
	
	public Boolean updateEmployee(Employee employee)
	{
		
		repository.save(employee);
		return true;
	}
	
	
	public Boolean deleteEmployee(int employeeid)
	{
		
		repository.deleteById(employeeid);
		return true;
	}
	
	public Boolean addEmployee(Employee employee)
	{
		
		repository.save(employee);
		return true;
	}
	
	public List<Employee> searchEmployee(int employeeId)
	{
		
		List<Employee> employees= repository.findByemployeeId(employeeId);
		return employees;
		
	}
	
	public List<Employee> searchProjectWiseEmployees(int projectCode)
	{
		
		List<Employee> employees= repository.findByprojectCode(projectCode);
		return employees;
		
	}
	
	public List<Employee> searchByName(String name)
	{
		
		List<Employee> employees= repository.searchbyName(name);
		return employees;
		
	}
	
}




