package com.github.alejopj.oesia.services.impl;

import com.github.alejopj.oesia.repositories.InputRepository;
import com.github.alejopj.oesia.repositories.impl.InputRepositoryImpl;
import com.github.alejopj.oesia.services.InputService;

public class InputServiceImpl implements InputService {
	
	private static InputServiceImpl service = new InputServiceImpl();
	private InputRepository repository = InputRepositoryImpl.getInstance();
	
	private InputServiceImpl() {
		// Singleton.
	}
	
	public static InputServiceImpl getInstance() {
		return service;
	}
	
	public String readLine() {
		
		return repository.readLine();
	}
	
}
