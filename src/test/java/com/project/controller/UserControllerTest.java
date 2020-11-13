package com.project.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.controller.UserController;
import com.project.model.Users;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/TestContext.xml")
@WebAppConfiguration
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void configTest() {
	    ServletContext servletContext = wac.getServletContext();
	     
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	}
	
	//---------------
	// Steven's Test
	//---------------
	
	@Test
	public void test() throws Exception{
		this.mockMvc.perform(get("/users")).andExpect(status().isOk()).andDo(print());
	}
	
	//---------------
	// Dylan's Test
	//---------------
	@Test
	public void testLogin() throws Exception{
		
		String url = "http://localhost:8080/api/users/validate";
		Users user = new Users();
		user.setUsername("ye");
		user.setPassword("ye");
		
		ObjectMapper map = new ObjectMapper();
		map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
		String userInJson = ow.writeValueAsString(user);
		
		System.out.println("user json as a string: " + userInJson);
		System.out.println("user json as a string from function: " + asJsonString(user));
		this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(user)))
				.andExpect(status().is4xxClientError());
	}

	private String asJsonString(Object o) {
		try {
			return new ObjectMapper().writeValueAsString(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
