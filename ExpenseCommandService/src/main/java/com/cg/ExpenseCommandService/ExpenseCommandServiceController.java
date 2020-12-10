package com.cg.ExpenseCommandService;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(value="Expense Command Service demo using logger and swagger")
public class ExpenseCommandServiceController {

	@Autowired
	private ExpenseCommandServiceProxy expenseProxy;
	
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseCommandServiceController.class);
	
	
	
	
	/***************************************add an expense **************************************/
	
	@ApiOperation(value = "createExpense", nickname = "createExpense") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Expense.class), 
	@ApiResponse(code = 500, message = "Failure", response = Expense.class)})
	@PostMapping("/addexpense")
	public boolean createProject(@RequestBody Expense expense)
	{
		boolean added=expenseProxy.createExpense(expense);
		if(added)
			return true;
		return false;
	}
	
	
	
	/*************************************** update an expense ********************************/
	@ApiOperation(value = "updateExpense", nickname = "updateExpense") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Expense.class), 
	@ApiResponse(code = 500, message = "Failure", response = Expense.class)})
	@PutMapping("/updateexpense")
	public boolean updateExpense(@RequestBody Expense expense)
	{
		boolean updated=expenseProxy.updateExpense(expense);
		if(updated)
			return true;
		return false;
	}

	
	/*************************************** delete an expense ********************************/
	@ApiOperation(value = "deleteExpense", nickname = "deleteExpense") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Expense.class), 
	@ApiResponse(code = 500, message = "Failure", response = Expense.class)})
	@DeleteMapping("/deleteexpense")
	public boolean deleteExpense (@RequestParam ("expenseCode") int expenseCode)
	{
		boolean deleted=expenseProxy.deleteExpense(expenseCode);
		if(deleted)
			return true;
		return false;
	}
	
	
}
