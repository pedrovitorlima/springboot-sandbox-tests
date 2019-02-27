package br.pedro.sandbox.mockito.service;

import org.springframework.stereotype.Service;

/**
 * This Service has a dependency with {@link MockitoService}.
 * It uses this Service to show a simple message. We going to write some
 * tests with Mockito using him.
 * 
 * @author Pedro Rodrigues
 * **/
@Service
public class ConversationService {

	public String sayHi() {
		return "Hi";
	}
}
