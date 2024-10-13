package com.hstn.crud_rest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails user1 = User.builder()
						.username("john")
						.password("{noop}test")
						.roles("EMPLOYEE")
						.build();

		UserDetails user2 = User.builder()
						.username("jane")
						.password("{noop}test")
						.roles("EMPLOYEE", "MANAGER")
						.build();

		UserDetails user3 = User.builder()
						.username("anna")
						.password("{noop}test")
						.roles("EMPLOYEE", "MANAGER", "ADMIN")
						.build();

		return new InMemoryUserDetailsManager(user1, user2, user3);
	}
}
