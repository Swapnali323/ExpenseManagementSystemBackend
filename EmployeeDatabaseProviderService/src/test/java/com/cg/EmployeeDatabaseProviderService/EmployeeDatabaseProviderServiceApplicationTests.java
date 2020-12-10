package com.cg.EmployeeDatabaseProviderService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.EmployeeDatabaseProviderService.EmployeeProvider.Employee;
import com.cg.EmployeeDatabaseProviderService.EmployeeProvider.EmployeeRepository;


/************************************Integration testing***********************/
//@WebMvcTest
//@DataJpaTest
//@WebIntegrationTest
@ComponentScan(basePackages = "com.cg.EmployeeDatabaseProviderService.EmployeeProvider")
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ExpenseManagementSystemApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-prod.properties")
class EmployeeDatabaseProviderServiceApplicationTests {
	@Autowired
	MockMvc mvc;
	@MockBean
	EmployeeRepository repository;
	
	/*************************testing get employees from sql db***************///////////
	@Test
	void loadAllEmployees() throws Exception {

		
		Mockito.when(repository.findAll()).thenReturn(java.util.Collections.emptyList());
		MvcResult result= mvc.perform(MockMvcRequestBuilders.get("/getemployees").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		System.out.println(result.getResponse());
		//List<Employee> emplist=repository.findAll();
		assertNotNull(result.getResponse());
		
	}
	/*************************testing get employees from sql db***************///////////
	@Test
	void loadEmptyEmployees() throws Exception {

		
		Mockito.when(repository.findAll()).thenReturn(java.util.Collections.emptyList());
		MvcResult result= mvc.perform(MockMvcRequestBuilders.get("/getemployees").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		System.out.println(result.getResponse());
		//List<Employee> emplist=repository.findAll();
		assertNull(result.getResponse());
		
	}

	/*************************testing delete existing employee on sql db***************///////////
	@Test
	void deleteExisitngEmployee() throws Exception {

		
		//Mockito.when(repository.delete)).thenReturn(java.util.Collections.emptyList());
		MvcResult result= mvc.perform(MockMvcRequestBuilders.delete("/deleteemployee?employeeId=9876").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		System.out.println(result.getResponse());
		//Mockito.verify(repository.findAll());
		
		assertEquals(true,result.getResponse());
	}
	
	/*************************testing delete non- existing employee on sql db***************///////////
	@Test
	void deleteNonExisitngEmployee() throws Exception {

		
		//Mockito.when(repository.delete)).thenReturn(java.util.Collections.emptyList());
		MvcResult result= mvc.perform(MockMvcRequestBuilders.delete("/deleteemployee?employeeId=9876").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		System.out.println(result.getResponse());
		//Mockito.verify(repository.findAll());
		
		assertNotEquals(true,result.getResponse());
	}
	/*************************testing search exisiting employee om sql db***************///////////
	@Test
	void searchExisitngEmployee() throws Exception {

		
		
		
		MvcResult result= mvc.perform(MockMvcRequestBuilders.get("/searchemployee?employeeId=9000").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		System.out.println(result.getResponse());
		//Mockito.verify(repository.findAll());
		//Employee emp=(Employee)result.getResponse();
		System.out.println(result.getResponse());
		assertNotEquals(null, result.getResponse());
	}
	/*************************testing search non-exisiting employee om sql db***************///////////
	@Test
	void searchNonexisitngEmployee() throws Exception {
		
		
		
		MvcResult result= mvc.perform(MockMvcRequestBuilders.get("/searchemployee?employeeId=2020").accept(MediaType.APPLICATION_JSON)).andReturn();
		//if(result.getResponse()==null)
		//	System.out.println(result.getResponse());
		//Mockito.verify(repository.findAll());
		//Employee emp=(Employee)result.getResponse();
		
		//assertEquals(true, result.getResponse());
		assertNull(result.getResponse());
		//assertThat(result.getResponse()).isNotEqualTo(null);
		
		
	}
	
	/***************************************************testing adding of employee record********************/
	
	@Test
	//@Sql
	void addEmployee() throws Exception {
		
		Employee employee1= new Employee(102, "david luiz", "ASHG1234", "Technical Associate", "Finance", "1965/02/02", "1944/02/01", 14500.00,"marcos90@gmail.com", 113);
		
		//MvcResult result= mvc.perform(MockMvcRequestBuilders.post("/addemployee?employee=Employee(102, \"david luiz\", \"ASHG1234\", \"Technical Associate\", \"Finance\", \"1965/02/02\", \"1944/02/01\", 14500.00,\"marcos90@gmail.com\", 113)").accept(MediaType.APPLICATION_JSON)).andReturn();
		/*if(result.getResponse()==null)
			System.out.println(result.getResponse());*/
		//Mockito.verify(repository.findAll());
		//Employee emp=(Employee)result.getResponse();
		
		//assertEquals(true, result.getResponse());
		//assertNull(result.getResponse());
		repository.save(employee1);
		assertThat(repository.searchbyName("luiz")).isNotNull();
		
	}
	
	
	/***************************************testing update employee record*/////////////////////////////////////////
	

	@Test
	//@Sql
	@Transactional
	void updateEmployee() throws Exception {
		
		Employee employee1= new Employee(5000, "david luiz", "ASHG1234", "Technical Associate", "Finance", "1965/02/02", "1944/02/01", 14500.00,"marcos90@gmail.com", 113);
		
		//MvcResult result= mvc.perform(MockMvcRequestBuilders.post("/addemployee?employee=Employee(102, \"david luiz\", \"ASHG1234\", \"Technical Associate\", \"Finance\", \"1965/02/02\", \"1944/02/01\", 14500.00,\"marcos90@gmail.com\", 113)").accept(MediaType.APPLICATION_JSON)).andReturn();
		/*if(result.getResponse()==null)
			System.out.println(result.getResponse());*/
		//Mockito.verify(repository.findAll());
		//Employee emp=(Employee)result.getResponse();
		
		//assertEquals(true, result.getResponse());
		//assertNull(result.getResponse());
		repository.save(employee1);
	
		//assertThat(repository.findByemployeeId(103)).isNull();
		//assertThat(repository.searchbyName("luiz")).isNotNull();
		//employee1.setName("rohan");
		//repository.save(employee1);
		//assertThat(repository.searchbyName("luiz")).isNotNull();
		assertNotEquals(null, repository.findById(5000));
	}
	
	
	
}
