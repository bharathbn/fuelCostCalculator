package com.benz.calculator.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.benz.calculator.utils.Constants;

/**
 * Handles authenticating api keys against the database.
 */
public class ApiKeyAuthManager implements AuthenticationManager {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String principal = (String) authentication.getPrincipal();

		if (!principal.equals(Constants.API_KEY_VALUE)) {
			throw new BadCredentialsException("The API key was not found or not the expected value.");
		} else {
			authentication.setAuthenticated(true);
			return authentication;
		}
	}

}