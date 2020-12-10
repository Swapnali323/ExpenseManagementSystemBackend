package com.cg.ClaimDatabaseProviderService.ExpenseClaimProvider;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

/*
 * 
 * @Author:prakash devar


 * 
 * Created on 29/4/2020
 */


@Entity
/***************************************Entity storing ExpenseClaim details*************************/
public class ExpenseClaim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseClaimId;
	@Column
	private int employeeId;
	@Column
	private int projectCode;
	@Column
	private int expenseCode;
	@Column
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
