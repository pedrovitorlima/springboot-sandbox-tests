package br.pedro.sandbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.pedro.sandbox.service.GreetingsService;

/**
 * This is a simple to controller with simple methods. This class exists
 * to allow us to write tests on Spring Boot to verify the web layer of a 
 * web application.
 * @author Pedro Rodrigues
 * **/
@Controller
public class WebLayerController {

	@Autowired
	private GreetingsService greetingsService;
	
	@RequestMapping("/")
	public @ResponseBody String welcome() {
		return greetingsService.sayGreetings();
	}
}
