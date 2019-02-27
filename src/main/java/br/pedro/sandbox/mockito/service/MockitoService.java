package br.pedro.sandbox.mockito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is a simple service to ilustrate some tests using Mockito with
 * Spring Boot.
 * 
 * @author Pedro Rodrigues
 * **/
@Service
public class MockitoService {

	@Autowired
	private ConversationService conversationService;
	
	public String getGreetingsMessage() {
		return conversationService.sayHi();
	}
}
