package com.cg.ExpenseQueryService;

/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
 
import java.util.List;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




/********************************proxy interface that communicates with database provider service*/////////////////////////////////
//@FeignClient(name="expensedatabaseproviderservice")
@FeignClient(name = "zuulserver")
@RibbonClient(name="expensedatabaseproviderservice")
public interface ExpenseQueryServiceProxy {

	/*******************************************Expense specific proxies*******************************/
	@GetMapping("/expensedatabaseproviderservice/getexpenses")
	public @ResponseBody List<Expense> getExpenses();
	
	
	@GetMapping("/expensedatabaseproviderservice/searchexpense")
	public List<Expense> searchExpense(@RequestParam ("expenseCode") int expenseCode);
	
	@GetMapping("/expensedatabaseproviderservice/searchexpensetype")
	public List<Expense> searchExpenseType(@RequestParam ("expenseType") String expenseType);
}
