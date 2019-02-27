package br.pedro.sandbox.mockito.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.pedro.sandbox.SpringBootTestApplication;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootTestApplication.class)
public class MockitoServiceTest {
	
	@Autowired
	private MockitoService mockitoService;
	
	@Test
	public void testMessageShow() {
		Mockito.when(mockitoService.getGreetingsMessage()).thenReturn("Hi");
		String testHi = mockitoService.getGreetingsMessage();
		
		assertThat(testHi).isEqualTo("Hi");
	}

}
