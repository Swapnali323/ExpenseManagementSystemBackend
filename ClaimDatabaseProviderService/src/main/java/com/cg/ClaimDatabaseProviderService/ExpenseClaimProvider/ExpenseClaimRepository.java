package com.cg.ClaimDatabaseProviderService.ExpenseClaimProvider;
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
public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaim, Integer>{

	
	
	//public Employee findByuserNameAndPassword(@Param("uname") String userName,@Param("pass") String password);
	
	
	public List<ExpenseClaim> findByexpenseClaimId(int expenseClaimid);
	
	public List<ExpenseClaim> findByemployeeId(int employeeId);
	
}
