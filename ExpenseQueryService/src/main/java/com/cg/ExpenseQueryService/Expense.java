package com.cg.ExpenseQueryService;

import java.util.Date;

/*
 * 
 * @Author:prakash devar


 * 
 * Created on 29/4/2020
 */


/***************************************Entity storing Expense details*************************/
public class Expense {

	
	private int expenseCode;
	private String expenseType;
	private String description;
	public int getExpenseCode() {
		return expenseCode;
	}
	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Expense(int expenseCode, String expenseType, String description) {
		super();
		this.expenseCode = expenseCode;
		this.expenseType = expenseType;
		this.description = description;
	}
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Expense [expenseCode=" + expenseCode + ", expenseType=" + expenseType + ", description=" + description
				+ "]";
	}
	
	
	
}
