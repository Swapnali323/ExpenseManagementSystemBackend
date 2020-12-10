package com.cg.EmployeeCommandService;

import java.util.Date;

/*
 * 
 * @Author:prakash devar


 * 
 * Created on 29/4/2020
 */


/***************************************Entity storing Employee details*************************/
public class Employee {

	
	private int employeeId;
	
	private String name;
	
	private String PANId;
	
	private String designation;
	
	private String domain;
	
	private String DOJ;
	
	private String DOB;
	
	private Double salary;
	
	private String mailId;
	
	private int projectCode;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPANId() {
		return PANId;
	}
	public void setPANId(String pANId) {
		this.PANId = pANId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		this.DOJ = dOJ;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		this.DOB = dOB;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public int getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", PANId=" + PANId + ", designation="
				+ designation + ", domain=" + domain + ", DOJ=" + DOJ + ", DOB=" + DOB + ", salary=" + salary
				+ ", mailId=" + mailId + ", projectCode=" + projectCode + "]";
	}
	public Employee(int employeeId, String name, String pANId, String designation, String domain, String dOJ,
			String dOB, Double salary, String mailId, int projectCode) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.PANId = pANId;
		this.designation = designation;
		this.domain = domain;
		this.DOJ = dOJ;
		this.DOB = dOB;
		this.salary = salary;
		this.mailId = mailId;
		this.projectCode = projectCode;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
