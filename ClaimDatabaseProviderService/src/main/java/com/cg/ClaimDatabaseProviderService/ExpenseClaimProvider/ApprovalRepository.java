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
public interface ApprovalRepository extends JpaRepository<Approval, Integer>{

	
	
	//public Employee findByuserNameAndPassword(@Param("uname") String userName,@Param("pass") String password);
	
	public List<Approval> findByexpenseClaimId(int expenseClaimid);
	
	public List<Approval> findByemployeeId(int employeeId);
	
	
}
