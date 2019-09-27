package com.drivebuzz.demo.miscellaneous;

import java.lang.reflect.Field;

public class FieldExtractor {

	public String extractUsername(Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Field usernameField = object.getClass().getDeclaredField("head");
		usernameField.setAccessible(true);
		
		String username = usernameField.get(object).toString().substring(9);
		
		return username;
	}
	
	public String extractPassword(Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Field passwordField = object.getClass().getDeclaredField("tail");
		passwordField.setAccessible(true);
		
		String password = passwordField.get(object).toString().substring(9);
		
		return password;
	}
}
