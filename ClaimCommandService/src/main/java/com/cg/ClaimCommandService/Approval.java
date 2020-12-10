package com.cg.ClaimCommandService;


import java.util.Date;

/*
 * 
 * @Author:prakash devar


 * 
 * Created on 29/4/2020
 */


/***************************************Entity storing claim approval details*************************/
public class Approval {

	
	private int expenseClaimId;
	private int employeeId;
	private int projectCode;
	private int expenseCode;
	private String status;
	public int getExpenseClaimId() {
		return expenseClaimId;
	}
	public void setExpenseClaimId(int expenseClaimId) {
		this.expenseClaimId = expenseClaimId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}
	public int getExpenseCode() {
		return expenseCode;
	}
	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Approval(int expenseClaimId, int employeeId, int projectCode, int expenseCode, String status) {
		super();
		this.expenseClaimId = expenseClaimId;
		this.employeeId = employeeId;
		this.projectCode = projectCode;
		this.expenseCode = expenseCode;
		this.status = status;
	}
	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Approval [expenseClaimId=" + expenseClaimId + ", employeeId=" + employeeId + ", projectCode="
				+ projectCode + ", expenseCode=" + expenseCode + ", status=" + status + "]";
	}
	
	
}
