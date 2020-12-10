package com.cg.ExpenseDatabaseProviderService.ExpenseProvider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*
 * 
 * @Author:prakash devar
 * 
 * Created on 30/4/2020
 */
 

@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RestController

public class ExpenseController {

	@Autowired
	private ExpenseRepository repository;
	@Autowired
	private Environment env;
	
	@Autowired
	private ExpenseServiceImpl service;
	
	 /***************************************retrieve all Expenses *///////////////////////
	@GetMapping("/getexpenses")
	public @ResponseBody List<Expense> getExpenses()
	{
		/*
		 * temporary list of Expenses
		 */
		List<Expense> tempList=new ArrayList<Expense>();
		
		//tempList=repository.findAll();
		tempList=service.getExpenses();
		return tempList;
	}
	
	
	 /*************************************** create an Expense ********************************/
		@PostMapping("/addexpense")
		public boolean createExpense(@RequestBody Expense expense)
		{
			boolean added=service.addExpense(expense);
			if(added)
				return true;
			return false;
		}
		
		
		/*************************************** update an Expense ********************************/
		@PutMapping("/updateexpense")
		public boolean updateExpense(@RequestBody Expense expense)
		{
			boolean updated=service.updateExpense(expense);
			if(updated)
				return true;
			return false;
		}
	
		
		/*************************************** delete an Expense ********************************/
		@DeleteMapping("/deleteexpense")
		public boolean deleteExpense(@RequestParam ("expenseCode") int expenseCode)
		{
			boolean deleted=service.deleteExpense(expenseCode);
			if(deleted)
				return true;
			return false;
		}
		
		
		/*************************************** search an Expense by id ********************************/
		@GetMapping("/searchexpense")
		public List<Expense> searchExpense(@RequestParam ("expenseCode") int expenseCode)
		{
			List<Expense> expense= service.searchExpense(expenseCode);
			return expense;
		}
		
		/*************************************** search an Expense by type ********************************/
		@GetMapping("/searchexpensetype")
		public List<Expense> searchExpenseType(@RequestParam ("expenseType") String expenseType)
		{
			List<Expense> expense= service.searchExpenseType(expenseType);
			return expense;
		}
}
