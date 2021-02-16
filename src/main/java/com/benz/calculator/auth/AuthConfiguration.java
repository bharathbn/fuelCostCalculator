package com.benz.calculator.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.benz.calculator.utils.Constants;

@Configuration
@EnableWebSecurity
@Order(1)
public class AuthConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ApiKeyAuthFilter filter = new ApiKeyAuthFilter(Constants.API_KEY);
        filter.setAuthenticationManager(new ApiKeyAuthManager());

        http.antMatcher("/v1/*").
                csrf().
                disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and()
                    .addFilter(filter)
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated();
    }
}
