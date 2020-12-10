package com.cg.ClaimDatabaseProviderService.ExpenseClaimProvider;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

public class ExpenseClaimController {

	@Autowired
	private ExpenseClaimRepository repository;
	@Autowired
	private Environment env;
	
	@Autowired
	private ExpenseClaimServiceImpl service;
	
	 /***************************************retrieve all claims *///////////////////////
	@GetMapping("/getclaims")
	public @ResponseBody List<ExpenseClaim> getClaims()
	{
		/*
		 * temporary list of claimS
		 */
		List<ExpenseClaim> tempList=new ArrayList<ExpenseClaim>();
		
		//tempList=repository.findAll();
		tempList=service.getClaims();
		return tempList;
	}
	
	
	 /*************************************** create an claim ********************************/
		@PostMapping("/addclaim")
		public boolean createClaim(@RequestBody ExpenseClaim claim)
		{
			boolean added=service.addClaim(claim);
			if(added)
				return true;
			return false;
		}
		
		
		/*************************************** update an claim ********************************/
		@PutMapping("/updateclaim")
		public boolean updateClaim(@RequestBody ExpenseClaim claim)
		{
			boolean updated=service.updateClaim(claim);
			if(updated)
				return true;
			return false;
		}
	
		
		/*************************************** delete an claim ********************************/
		@DeleteMapping("/deleteclaim")
		public boolean deleteClaim(@RequestParam("claimId") int claimId)
		{
			boolean deleted=service.deleteClaim(claimId);
			if(deleted)
				return true;
			return false;
		}
		
		
		/*************************************** search an claim ********************************/
		@GetMapping("/searchclaim")
		public List<ExpenseClaim> searchClaim(@RequestParam("claimId") int claimId)
		{
				List<ExpenseClaim> claim= service.searchClaim(claimId);
				return claim;
		}
		
		
		/*************************************** get employee wise claims ********************************/
		@GetMapping("/employeewiseclaims")
		public List<ExpenseClaim> getEmployeeWiseClaims(@RequestParam("employeeId") int employeeId)
		{
			List<ExpenseClaim> claim= service.searchemployeewise(employeeId);
			return claim;
		}
		
		/**************************************Add approval status for claims********************************/
		@PostMapping("/addstatus")
		public boolean addStatus(@RequestBody Approval approval)
		{
			boolean added=service.addStatus(approval);
			if(added)
				return true;
			return false;
		}
		
		
		/******************************************get all claim approvals*****************************/
		@GetMapping("/getapprovals")
		public @ResponseBody List<Approval> getapprovals()
		{
			

			/*
			 * temporary list of approvals
			 */
			List<Approval> tempList=new ArrayList<Approval>();
			
			//tempList=repository.findAll();
			tempList=service.getApprovals();
			return tempList;
		}
		
		/***************************************search approval by claim id****************************/
		
		
		@GetMapping("/searchapproval")
		public List<Approval> searchApproval(@RequestParam("claimId") int claimId)
		{
			
			List<Approval> approval=service.searchApproval(claimId);
			return approval;
		}
		
		/*************************************** get employee wise claim approvals ********************************/
		@GetMapping("/employeewiseapprovals")
		public List<Approval> getEmployeeWiseApprovals(@RequestParam("employeeId") int employeeId)
		{
			List<Approval> approval= service.searchemployeewiseapproval(employeeId);
			return approval;
		}
}
