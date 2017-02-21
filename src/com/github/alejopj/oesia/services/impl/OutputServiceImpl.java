package com.github.alejopj.oesia.services.impl;

import com.github.alejopj.oesia.repositories.OutputRepository;
import com.github.alejopj.oesia.repositories.impl.OutputRepositoryImpl;
import com.github.alejopj.oesia.services.OutputService;

public class OutputServiceImpl implements OutputService {
	
	private static OutputServiceImpl service = new OutputServiceImpl();
	private OutputRepository repository = OutputRepositoryImpl.getInstance();

	private OutputServiceImpl() {
		// Singleton.
	}
	
	public static OutputServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void writeLine(String line) {
		
		repository.writeLine(line);
	}
	
}
