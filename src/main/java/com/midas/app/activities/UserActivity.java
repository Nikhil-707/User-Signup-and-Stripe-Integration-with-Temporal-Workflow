package com.midas.app.activities;

import org.springframework.stereotype.Component;

@Component
public class UserActivity {

	// Example method to perform some user-related action
	public void createUser(String username, String email) {
		// Logic to create a user
		System.out.println("User created with username: " + username + " and email: " + email);
	}
}
