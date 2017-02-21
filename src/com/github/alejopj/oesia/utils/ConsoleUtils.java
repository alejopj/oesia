package com.github.alejopj.oesia.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUtils {
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static String readLine() {
		
		String line = null;
		
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		return line;
	}
}
