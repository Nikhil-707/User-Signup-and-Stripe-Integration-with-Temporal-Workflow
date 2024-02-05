package com.midas.app.utils;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StripeIntegrationTest {

	@Test
	void createCustomer() {
		// Set your Stripe API key
		Stripe.apiKey = "sk_test_51OgQ64SEck1MgIokCBvn1SEDNPsiNP1H8EsgvIav7FnsCXjigfBMxNTgWDlydtX6ozLtJqhT8P7XEykAaufORNwJ00jHM6PvHQ";

		try {
			// Create a new customer with a test email
			Customer customer = Customer.create(
					CustomerCreateParams.builder()
							.setEmail("test@example.com")
							.build()
			);

			// Assert that the customer ID is not null or empty
			assertNotNull(customer.getId());
			assertFalse(customer.getId().isEmpty());

			// Print the customer ID for reference
			System.out.println("Customer ID: " + customer.getId());
		} catch (StripeException e) {
			// Handle Stripe API exceptions
			e.printStackTrace();
			fail("StripeException occurred: " + e.getMessage());
		}
	}
}
