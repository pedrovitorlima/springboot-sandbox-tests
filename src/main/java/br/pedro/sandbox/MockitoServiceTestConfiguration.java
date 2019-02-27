package br.pedro.sandbox;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import br.pedro.sandbox.mockito.service.MockitoService;

/**
 * This configuration class creates a mock bean with name mockitoService,
 * valid only when the "test" profile is active with @ActiveProfiles("test").
 * See application.properties to neccessary configuration.
 * @author Pedro Rodrigues
 * **/
@Profile("test") //Apply this configuration only when "test" profile is active
@Configuration
public class MockitoServiceTestConfiguration {

	@Bean
	@Primary //This instance will be used instead primary DI instance
	public MockitoService mockitoService() {
		return Mockito.mock(MockitoService.class);
	}
}
