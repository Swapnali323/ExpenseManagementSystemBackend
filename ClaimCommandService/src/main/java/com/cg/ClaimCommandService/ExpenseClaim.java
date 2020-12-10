package com.cg.ClaimCommandService;

import java.util.Date;

/*
 * 
 * @Author:prakash devar


 * 
 * Created on 29/4/2020
 */


/***************************************Entity storing ExpenseClaim details*************************/
public class ExpenseClaim {

	
	private int expenseClaimId;
	private int employeeId;
	private int projectCode;
	private int expenseCode;
	private double amount;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ExpenseClaim(int expenseClaimId, int employeeId, int projectCode, int expenseCode, double amount) {
		super();
		this.expenseClaimId = expenseClaimId;
		this.employeeId = employeeId;
		this.projectCode = projectCode;
		this.expenseCode = expenseCode;
		this.amount = amount;
	}
	public ExpenseClaim() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ExpenseClaim [expenseClaimId=" + expenseClaimId + ", employeeId=" + employeeId + ", projectCode="
				+ projectCode + ", expenseCode=" + expenseCode + ", amount=" + amount + "]";
	}
		
}
