package com.cg.ExpenseCommandService;

import java.util.Collections;

/*
 * 
 * @Author:prakash devar


 * 
 * Created on 29/4/2020
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/*
 * 
 * @Author:prakash devar


 * 
 * Created on 29/4/2020
 */


@SpringBootApplication
@EnableFeignClients("com.cg.ExpenseCommandService")
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
//@EnableDiscoveryClient
@EnableSwagger2
//@EnableWebSecurity
//@EnableOAuth2Sso
public class ExpenseCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseCommandServiceApplication.class, args);
	}

	@Bean //for swagger documentation purpose
	public Docket swaggerConfiguration() 
	{ 
		return new Docket(DocumentationType.SWAGGER_2).
				select().paths(PathSelectors.any()).
				apis(RequestHandlerSelectors.basePackage("com.cg.ExpenseCommandService")).build().
				apiInfo(myApiInfo()); 
	}
	//set api info to be displayed on swagger ui.html
	private ApiInfo myApiInfo()
	{ // for version 2.9.1 
		ApiInfo apiInfo=new ApiInfo( "SPRING WITH SWAGGER API", "API CREATION", "1.0", "Free to Use", new Contact("Prakash Devar","/ExpenseCommandService" ,"prakashdevar1997@gmail.com"), "API licence", "/ExpenseCommandService", Collections.emptyList());
		return apiInfo; 
		
	}
	
}
