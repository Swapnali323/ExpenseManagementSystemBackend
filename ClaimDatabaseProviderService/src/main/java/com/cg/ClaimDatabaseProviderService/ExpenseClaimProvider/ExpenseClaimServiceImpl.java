package com.cg.ClaimDatabaseProviderService.ExpenseClaimProvider;

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
public class ExpenseClaimServiceImpl {

	@Autowired
	private ExpenseClaimRepository repository;
	@Autowired
	private ApprovalRepository arepository;
	public List<ExpenseClaim> getClaims()
	{
		return repository.findAll();
	}
	
	public Boolean updateClaim(ExpenseClaim claim)
	{
		
		repository.save(claim);
		return true;
	}
	
	
	public Boolean deleteClaim(int claimid)
	{
		
		repository.deleteById(claimid);
		return true;
	}
	
	public Boolean addClaim(ExpenseClaim claim)
	{
		
		repository.save(claim);
		return true;
	}
	
	
	public List<ExpenseClaim> searchClaim(int claimId)
	{
		
		List<ExpenseClaim> claim= repository.findByexpenseClaimId(claimId);
		return claim;
		
	}
	
	
	public List<ExpenseClaim> searchemployeewise(int employeeId)
	{
		
		List<ExpenseClaim> claim= repository.findByemployeeId(employeeId);
		return claim;
		
	}
	
	public Boolean addStatus(Approval approval)
	{
		
		arepository.save(approval);
		return true;
	}
	
	public List<Approval> getApprovals()
	{
		return arepository.findAll();
	}
	
	
	public List<Approval> searchApproval(int claimId)
	{
		
		List<Approval> approval= arepository.findByexpenseClaimId(claimId);
		return approval;
		
	}
	public List<Approval> searchemployeewiseapproval(int employeeId)
	{
		
		List<Approval> approval= arepository.findByemployeeId(employeeId);
		return approval;
		
	}
}




