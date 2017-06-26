package com.teja.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("teja").password("teja").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	  
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
	 	.antMatchers("/","/add**","/contact**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/","/users**","/register**").access("hasRole('ROLE_USER')")
		
		
		.and().formLogin().loginPage("/login").permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403").and()
		.logout();

	}
}
