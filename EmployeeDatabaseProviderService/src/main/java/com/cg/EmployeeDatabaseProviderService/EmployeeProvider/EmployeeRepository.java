package com.cg.EmployeeDatabaseProviderService.EmployeeProvider;
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
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	
	//public Employee findByuserNameAndPassword(@Param("uname") String userName,@Param("pass") String password);
	
	
	public List<Employee> findByemployeeId(int employeeId);
	
	public List<Employee> findByprojectCode(int projectCode);
	
	@Query(value = "select employee from Employee employee where employee.name like %?1%")
	public List<Employee> searchbyName(String name);
	
}
