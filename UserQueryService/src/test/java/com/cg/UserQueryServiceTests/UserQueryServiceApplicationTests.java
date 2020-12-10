package com.cg.UserQueryServiceTests;



import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.UserQueryService.User;
import com.cg.UserQueryService.UserQueryServiceApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

//@WebMvcTest
@ComponentScan(basePackages = "com.cg.UserQueryService")
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = UserQueryServiceApplication.class)
@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-prod.properties")
/*************************Unit testing of resource ********************/////////
class UserQueryServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	/********************************valid credentails************************************/
	@Test
	void validCredentials() throws Exception {
		User user = new User();

		user.setUserName("amit");
		user.setPassword("admin");

		String inputJson = objectMapper.writeValueAsString(user);

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		System.out.println(result.getResponse());
		User log = objectMapper.readValue(result.getResponse().getContentAsString(), User.class);
		assertEquals("Admin", log.getRole());

	}
	/********************************Invalid credentails************************************/
	@Test
	void invalidcredentials() throws Exception {
		User user = new User();

		user.setUserName("prakash");
		user.setPassword("employee");

		String inputJson = objectMapper.writeValueAsString(user);

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		System.out.println(result.getResponse());
		User log = objectMapper.readValue(result.getResponse().getContentAsString(), User.class);
		assertEquals("Employe",log.getRole());
		//assertNotEquals("Admin", log.getRole());
		System.out.println("invalid log role caught"+log.getRole());

	}


}
