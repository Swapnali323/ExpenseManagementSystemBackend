package com.cg.ProjectQueryService;

import java.util.Date;

/*
 * 
 * @Author:prakash devar


 * 
 * Created on 29/4/2020
 */


/***************************************Entity storing Project details*************************/
public class Project {

	
	private int projectCode;
	private String description;
	private String projectStartDate;
	private String projectEndDate;
	public int getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public String getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	public Project(int projectCode, String description, String projectStartDate, String projectEndDate) {
		super();
		this.projectCode = projectCode;
		this.description = description;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Project [projectCode=" + projectCode + ", description=" + description + ", projectStartDate="
				+ projectStartDate + ", projectEndDate=" + projectEndDate + "]";
	}
	
	
}
