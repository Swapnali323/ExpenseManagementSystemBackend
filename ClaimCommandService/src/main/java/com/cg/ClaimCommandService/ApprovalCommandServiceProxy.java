package com.cg.ClaimCommandService;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



	

/********************************proxy interface that communicates with database provider service*/////////////////////////////////
//@FeignClient(name="claimdatabaseproviderservice")
//@FeignClient(name = "zuulserver")
//@RibbonClient(name="claimdatabaseproviderservice")

	/*******************************************Claim Approval specific proxies*******************************/
public interface ApprovalCommandServiceProxy {	
	
	@PostMapping("/claimdatabaseproviderservice/addstatus")
	public boolean addStatus(@RequestBody Approval approval);
	

	
	
}


