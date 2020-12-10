package com.cg.ExpenseCommandService;

/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 
import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/********************************proxy interface that communicates with database provider service*/////////////////////////////////
//@FeignClient(name="expensedatabaseproviderservice")
@FeignClient(name = "zuulserver")
@RibbonClient(name="expensedatabaseproviderservice")
public interface ExpenseCommandServiceProxy {

	/*******************************************Expense specific proxies*******************************/
	
	
	
	@PostMapping("/expensedatabaseproviderservice/addexpense")
	public boolean createExpense(@RequestBody Expense expense);
	
	
	@PutMapping("/expensedatabaseproviderservice/updateexpense")
	public boolean updateExpense(@RequestBody Expense expense);
	
	@DeleteMapping("/expensedatabaseproviderservice/deleteexpense")
	public boolean deleteExpense(@RequestParam ("expenseCode") int expenseCode);
	
	
	
	
}
