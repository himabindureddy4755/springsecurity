package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//set the config on the auth object
		auth.inMemoryAuthentication()
		.withUser("himani")
		.password("bindu")
		.roles("USER")
		.and()
		.withUser("bindu")
		.password("himani")
		.roles("ADMIN");
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin")//match for all the paths
		.hasRole("ADMIN")
		.antMatchers("/user").hasRole("User")
		
		.antMatchers("/").permitAll()
		
		//.hasAnyRole("_","_")
		.and()
		.formLogin();
	}

}