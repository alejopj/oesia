package com.github.alejopj.oesia.repositories.impl;

import com.github.alejopj.oesia.repositories.OutputRepository;

public class OutputRepositoryImpl implements OutputRepository {

	private static OutputRepositoryImpl repository = new OutputRepositoryImpl();
	
	private OutputRepositoryImpl() {
		// Singleton.
	}
	
	public static OutputRepositoryImpl getInstance() {
		return repository;
	}
	
	@Override
	public void writeLine(String line) {
		
		System.out.println(line);
	}	

}
