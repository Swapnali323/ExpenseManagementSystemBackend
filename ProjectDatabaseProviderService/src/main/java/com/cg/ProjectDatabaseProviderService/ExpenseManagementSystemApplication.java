package com.cg.ProjectDatabaseProviderService;

import org.springframework.boot.SpringApplication;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExpenseManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagementSystemApplication.class, args);
	}

}
