package com.cg.ClaimQueryService;

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
//@FeignClient(name="claimdatabaseproviderservice")
@FeignClient(name = "zuulserver")
@RibbonClient(name="claimdatabaseproviderservice")
public interface ClaimQueryServiceProxy {

	/*******************************************ExpenseClaim specific proxies*******************************/
	@GetMapping("/claimdatabaseproviderservice/getclaims")
	public @ResponseBody List<ExpenseClaim> getclaims();
	
	
	@GetMapping("/claimdatabaseproviderservice/searchclaim")
	public List<ExpenseClaim> searchcClaim(@RequestParam("claimId") int claimId);
	
	@GetMapping("/claimdatabaseproviderservice/employeewiseclaims")
	public List<ExpenseClaim> getEmployeeWiseClaims(@RequestParam("employeeId") int employeeId);
	
	@GetMapping("/claimdatabaseproviderservice/getapprovals")
	public @ResponseBody List<Approval> getapprovals();
	
	
	@GetMapping("/claimdatabaseproviderservice/searchapproval")
	public List<Approval> searchApproval(@RequestParam("claimId") int claimId);
	
	@GetMapping("/claimdatabaseproviderservice/employeewiseapprovals")
	public List<Approval> getEmployeeWiseApprovals(@RequestParam("employeeId") int employeeId);
	
	
	
}
