package br.pedro.sandbox.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingsService {

	public String sayGreetings() {
		return "Welcome, friend!";
	}
}
