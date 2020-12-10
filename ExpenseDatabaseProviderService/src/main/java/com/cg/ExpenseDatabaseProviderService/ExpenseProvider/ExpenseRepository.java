package com.cg.ExpenseDatabaseProviderService.ExpenseProvider;
/*
 * 
 * @Author:prakash devar
 * 
 * Created on 29/4/2020
 */
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import feign.Param;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

	
	
	//public Employee findByuserNameAndPassword(@Param("uname") String userName,@Param("pass") String password);
	
	public List<Expense> findByexpenseCode(int expenseCode);
	
	@Query(value = "select expense from Expense expense where expense.expenseType like %?1%")
	public List<Expense> searchbyexpenseType(String expenseType);
}
