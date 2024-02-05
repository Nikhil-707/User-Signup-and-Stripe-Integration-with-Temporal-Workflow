package com.midas.app.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	private final midas.app.utils.StripeIntegration stripeIntegration;

	// Constructor to inject StripeIntegration dependency
	public ApplicationController(midas.app.utils.StripeIntegration stripeIntegration) {
		this.stripeIntegration = stripeIntegration;
	}

	@PostMapping("/signup")
	public void signup(@RequestBody midas.app.models.UserModel user) {
		try {
			// Call Stripe integration to create customer
			String customerId = stripeIntegration.createCustomer(user.getEmail());

			// Update user model with new fields
			user.setProviderType("stripe");
			user.setProviderId(customerId);

			// Save user to database or perform further operations
		} catch (Exception e) {
			e.printStackTrace();
			// Handle error
		}
	}
}
