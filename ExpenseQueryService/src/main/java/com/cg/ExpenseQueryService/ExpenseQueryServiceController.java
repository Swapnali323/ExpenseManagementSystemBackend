package com.cg.ExpenseQueryService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 
@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RestController
@Api(value="Expense Query Service demo using logger and swagger")
public class ExpenseQueryServiceController {

	@Autowired
	private ExpenseQueryServiceProxy expenseProxy;
	
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseQueryServiceController.class);
	
	
	/***************************************retrieve all Expenses *///////////////////////
	@HystrixCommand(fallbackMethod = "alternateExpensesList")
	@ApiOperation(value = "getExpenses", nickname = "getExpenses") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Expense.class), 
	@ApiResponse(code = 500, message = "Failure", response = Expense.class)})
	@GetMapping(path="/getexpenses")
	public List<Expense> getExpenses()
	{
		List<Expense> expenselist=expenseProxy.getExpenses();
		if (expenselist.size()<1)
		{
			throw new RuntimeException("no Expenses available");
		}
		return expenselist;
	}
	
	
	/***************************************fall back method for retrieve all Expenses *///////////////////////
	
	public List<Expense> alternateExpensesList()
	{ 
		logger.info("\"Due to Exception, the fallbackmethod for get all Expenses has been invoked by Hystrix");
		System.out.println("inside alternateMethod"); 
		Date date = new Date();
		List<Expense> tempList=new ArrayList<Expense>();
		Expense exp1=new Expense(201,"Location cost","overseas");
		Expense exp2=new Expense(202,"Rental cost","business");
		
		tempList.add(exp1);
		tempList.add(exp2);
		return tempList;
	}
	
	
	
	/*************************************** search an expense by code ********************************/
	@ApiOperation(value = "searchExpense", nickname = "searchExpense") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Expense.class), 
	@ApiResponse(code = 500, message = "Failure", response = Expense.class)})
	@GetMapping("/searchexpense")
	public List<Expense> searchExpense(@RequestParam ("expenseCode") int expenseCode)
	{
		List<Expense> expense= expenseProxy.searchExpense(expenseCode);
		return expense;
	}
	
	/*************************************** search an expense by type ********************************/
	@ApiOperation(value = "searchExpenseType", nickname = "searchExpenseType") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Expense.class), 
	@ApiResponse(code = 500, message = "Failure", response = Expense.class)})
	@GetMapping("/searchexpensetype")
	public List<Expense> searchExpenseType(@RequestParam ("expenseType") String expenseType)
	{
		List<Expense> expense= expenseProxy.searchExpenseType(expenseType);
		return expense;
	}
}
