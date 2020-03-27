package com.project.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {

	 @EnableWebSecurity
	    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	        /**
	         * disable CSRF
	         * @param http
	         * @throws Exception
	         */
	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	            http.csrf().disable();
	        }
	    }

	public static void main(String[] args) {
		SpringApplication.run(RegistryApplication.class, args);
	}

}
