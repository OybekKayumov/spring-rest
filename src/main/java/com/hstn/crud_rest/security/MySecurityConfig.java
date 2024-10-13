package com.hstn.crud_rest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {

	//todo_ crete users, test:test from app.props won't work
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

	//todo_ user roles
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configer -> configer
		  .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
	  	.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
	  	.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
	  	.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
	  	.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
		);

		http.httpBasic(Customizer.withDefaults());
		http.csrf(csfr -> csfr.disable());

		return http.build();
	}
}
