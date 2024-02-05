package com.midas.app.utils;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;

public class StripeIntegration {

	private static final String STRIPE_API_KEY = "sk_test_51OgQ64SEck1MgIokCBvn1SEDNPsiNP1H8EsgvIav7FnsCXjigfBMxNTgWDlydtX6ozLtJqhT8P7XEykAaufORNwJ00jHM6PvHQ";

	public static String createCustomer(String email) throws StripeException {
		Stripe.apiKey = STRIPE_API_KEY;

		Customer customer = Customer.create(
				CustomerCreateParams.builder()
						.setEmail(email)
						.build()
		);

		return customer.getId();
	}
}