package com.cg.UserQueryService;

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
@FeignClient(name="logindatabaseproviderservice")
//@FeignClient(name="zuulserver")
@RibbonClient(name="logindatabaseproviderservice")
public interface UserQueryServiceProxy {

	/*******************************************User specific proxies*******************************/
	@GetMapping("/logindatabaseproviderservice/getusers")
	public @ResponseBody List<User> getUsers();
	
	

	@PostMapping("/login/username/{uname}/password/{pass}")
	public User validateUser(@PathVariable ("uname")String uname,@PathVariable("pass") String pass);
	
	

	
}
