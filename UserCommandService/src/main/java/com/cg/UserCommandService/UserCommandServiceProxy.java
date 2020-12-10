package com.cg.UserCommandService;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/********************************proxy interface that communicates with database provider service*/////////////////////////////////
//@FeignClient(name="logindatabaseproviderservice")
@FeignClient(name = "zuulserver")
@RibbonClient(name="logindatabaseproviderservice")
public interface UserCommandServiceProxy {

	/*******************************************User specific proxies*******************************/

	@PostMapping("/logindatabaseproviderservice/adduser")
	public boolean createUser(@RequestBody User user);
	
	
	/*************************************** update an user ********************************/
	@PutMapping("/logindatabaseproviderservice/updateuser")
	public boolean updateUser(@RequestBody User user);
}
