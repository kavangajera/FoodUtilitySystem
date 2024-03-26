package com.foodUtilitySystem.KhaanaBachaoApp.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class FoodSaverSecurityConfig {
      
	@Bean 
	UserDetailsManager userDetailsManager(DataSource datasource) {
		return new JdbcUserDetailsManager(datasource);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer->
		    configurer
		              .requestMatchers(HttpMethod.GET,"/api/foodSavers").hasRole("ADMIN")
		              .requestMatchers(HttpMethod.GET,"/api/foodSavers/**").hasRole("ADMIN")
		              .requestMatchers(HttpMethod.POST,"/api/foodSavers").hasRole("ADMIN")
		              .requestMatchers(HttpMethod.DELETE,"/api/foodSavers/**").hasRole("ADMIN")
		              .requestMatchers(HttpMethod.GET,"/api/volunteers").hasRole("VOLUNTEER") 
		              .requestMatchers(HttpMethod.PUT,"/api/foodSavers").hasRole("VOLUNTEER")
		              .requestMatchers(HttpMethod.POST,"/api/volunteers").hasRole("VOLUNTEER")
		              .requestMatchers(HttpMethod.DELETE,"/api/volunteers/**").hasRole("VOLUNTEER")
		              .requestMatchers(HttpMethod.GET,"/api/received").hasRole("VOLUNTEER")
		              .requestMatchers(HttpMethod.GET,"/api/volunteers/**").hasRole("DONOR")
		              .requestMatchers(HttpMethod.GET,"/api/donors").hasRole("DONOR")
		              .requestMatchers(HttpMethod.PUT,"/api/volunteers/**").hasRole("DONOR")
		              
		             
		               
				);
		
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf->csrf.disable());
		return http.build();
	}
}
