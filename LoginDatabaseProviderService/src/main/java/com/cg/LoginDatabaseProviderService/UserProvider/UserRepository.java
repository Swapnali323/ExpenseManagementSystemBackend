package com.cg.LoginDatabaseProviderService.UserProvider;
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
public interface UserRepository extends JpaRepository<User, Integer>{

	
	
	public User findByuserNameAndPassword(@Param("uname") String userName,@Param("pass") String password);
	
	
	
	
}
