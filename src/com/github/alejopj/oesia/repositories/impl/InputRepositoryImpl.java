package com.github.alejopj.oesia.repositories.impl;

import com.github.alejopj.oesia.repositories.InputRepository;
import com.github.alejopj.oesia.utils.ConsoleUtils;

public class InputRepositoryImpl implements InputRepository {

	private static InputRepositoryImpl repository = new InputRepositoryImpl();
	
	private InputRepositoryImpl() {
		// Singleton.
	}
	
	public static InputRepositoryImpl getInstance() {
		return repository;
	}
	
	@Override
	public String readLine() {
		
		return ConsoleUtils.readLine();
	}

}
