package br.pedro.sandbox.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.pedro.sandbox.service.GreetingsService;


/**
 * Test our Web Layer using controller {@link WebLayerController} using mock.
 * With this approach, we load only the {@link WebLayerController} in web layer. 
 * No needs to initialize server.
 * @author Pedro Rodrigues
 * **/

@RunWith(SpringRunner.class)
@WebMvcTest(WebLayerController.class)
public class WebLayerControllerTestWithMock {
	
	@Autowired
	private MockMvc mockMvc;
	
	//Our WebLayerController has a GreetingsService dependency.
	//Here we are loading only the WebLayerController, not the entire context, so Spring cant inject
	//the dependency. We need to declare this mock to allow Spring to fill it on our controller.
	@MockBean
	private GreetingsService greetingsService;
	
	
	@Before
	public void configureGreetingsService() {
		//We are working with mocks, not with real instances. So here we are saying
		//that: when we call #sayGreetings(), return this String: "Welcome, friend!"
		when(greetingsService.sayGreetings()).thenReturn("Welcome, friend!");
	}
	
	@Test
	public void welcomeShouldReturnCorrectMessage_withoutMock() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print())
			.andExpect(content().string(containsString("Welcome, friend!")));
	}
	
}
