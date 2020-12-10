package com.cg.ExpenseDatabaseProviderService.ExpenseProvider;

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
public class ExpenseServiceImpl {

	@Autowired
	private ExpenseRepository repository;
	
	public List<Expense> getExpenses()
	{
		return repository.findAll();
	}
	
	public Boolean updateExpense(Expense expense)
	{
		
		repository.save(expense);
		return true;
	}
	
	
	public Boolean deleteExpense(int expenseid)
	{
		
		repository.deleteById(expenseid);
		return true;
	}
	
	public Boolean addExpense(Expense expense)
	{
		
		repository.save(expense);
		return true;
	}
	
	

	public List<Expense> searchExpense(int expenseCode)
	{
		
		List<Expense> expense= repository.findByexpenseCode(expenseCode);
		return expense;
		
	}
	
	
	public List<Expense> searchExpenseType(String expenseType)
	{
		
		List<Expense> expense= repository.searchbyexpenseType(expenseType);
		return expense;
		
	}
	
	
	
}




