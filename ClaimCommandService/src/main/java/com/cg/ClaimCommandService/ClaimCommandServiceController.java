package com.cg.ClaimCommandService;

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
@Api(value="ClaimCommandService demo using logger and swagger")
public class ClaimCommandServiceController {

	@Autowired
	private ClaimCommandServiceProxy claimProxy;
	
	/*@Autowired 
	private ApprovalCommandServiceProxy appProxy;*/
	@Autowired
	private Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimCommandServiceController.class);
	
	
	
	
	/***************************************add an claim **************************************/
	
	@ApiOperation(value = "createClaim", nickname = "createClaim") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ExpenseClaim.class), 
	@ApiResponse(code = 500, message = "Failure", response = ExpenseClaim.class)})
	@PostMapping("/addclaim")
	public boolean createClaim(@RequestBody ExpenseClaim claim)
	{
		boolean added=claimProxy.createClaim(claim);
		if(added)
			return true;
		return false;
	}
	
	
	
	/*************************************** update an claim ********************************/
	@ApiOperation(value = "updateClaim", nickname = "updateClaim") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ExpenseClaim.class), 
	@ApiResponse(code = 500, message = "Failure", response = ExpenseClaim.class)})
	@PutMapping("/updateclaim")
	public boolean updateClaim(@RequestBody ExpenseClaim claim)
	{
		boolean updated=claimProxy.updateClaim(claim);
		if(updated)
			return true;
		return false;
	}

	
	/*************************************** delete an claim ********************************/
	@ApiOperation(value = "deleteClaim", nickname = "deleteClaim") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ExpenseClaim.class), 
	@ApiResponse(code = 500, message = "Failure", response = ExpenseClaim.class)})
	@DeleteMapping("/deleteclaim")
	public boolean deleteClaim(@RequestParam("claimId") int claimId)
	{
		boolean deleted=claimProxy.deleteClaim(claimId);
		if(deleted)
			return true;
		return false;
	}
	
	/***************************************add an approval status for claim **************************************/
	
	@ApiOperation(value = "addStatus", nickname ="addStatus") 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Approval.class), 
	@ApiResponse(code = 500, message = "Failure", response = Approval.class)})
	@PostMapping("/addstatus")
	public boolean addStatus(@RequestBody Approval approval)
	{
		boolean added=claimProxy.addStatus(approval);
		if(added)
			return true;
		return false;
	}
	
}
