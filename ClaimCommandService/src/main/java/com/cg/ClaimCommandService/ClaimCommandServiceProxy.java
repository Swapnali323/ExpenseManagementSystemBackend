package com.cg.ClaimCommandService;

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
public interface ClaimCommandServiceProxy {

	/*******************************************ExpenseClaim specific proxies*******************************/
	
	
	@PostMapping("/claimdatabaseproviderservice/addclaim")
	public boolean createClaim(@RequestBody ExpenseClaim claim);
	
	
	@PutMapping("/claimdatabaseproviderservice/updateclaim")
	public boolean updateClaim(@RequestBody ExpenseClaim claim);
	
	@DeleteMapping("/claimdatabaseproviderservice/deleteclaim")
	public boolean deleteClaim(@RequestParam("claimId") int claimId);
	
	@PostMapping("/claimdatabaseproviderservice/addstatus")
	public boolean addStatus(@RequestBody Approval approval);
	
}
