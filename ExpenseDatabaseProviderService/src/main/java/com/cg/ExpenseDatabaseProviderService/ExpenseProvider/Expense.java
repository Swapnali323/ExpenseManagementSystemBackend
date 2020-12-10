package com.cg.ExpenseDatabaseProviderService.ExpenseProvider;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * 
 * @Author:prakash devar


 * 
 * Created on 29/4/2020
 */

@Entity
/***************************************Entity storing Expense details*************************/
public class Expense {

	
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int expenseCode;
	@Column
	private String expenseType;
	@Column
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
