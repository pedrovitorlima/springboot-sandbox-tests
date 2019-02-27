package br.pedro.sandbox.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * Test our Web Layer using controller {@link WebLayerController} with no mock.
 * With this approach, we start the server and load all application layers.
 * Here, we need a server up and running.
 * @author Pedro Rodrigues
 * **/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT) //to not conflict with our started app
public class WebLayerControllerTest {

	@Autowired
	WebLayerController controller;
	
	//Allow us to call URLs mapped by controllers
	@Autowired
	private TestRestTemplate restTemplate;
	
	//Inject the used port on test. This is useful to know
	//how to mount the URL to make a controller call
	@LocalServerPort
	private int port;
	
	@Test
	public void contextLoads() throws Exception{
		//Context initialization needs to be fine!
		//The method assertThat is from assertJ. See more here: https://joel-costigliola.github.io/assertj/
		assertThat(controller).isNotNull();
		
		//Also, we could use Hamcrest to, importing follow:	
		//import static org.hamcrest.MatcherAssert.assertThat;
		//import static org.hamcrest.Matchers.*;
		//assertThat(controller, is(notNullValue()));
	}
	
	@Test
	public void welcomeShouldReturnCorrectMessage_withoutMock() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
			.contains("Welcome, friend!");
	}
	
}
