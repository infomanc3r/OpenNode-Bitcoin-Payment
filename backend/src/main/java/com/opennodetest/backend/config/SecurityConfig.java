package com.opennodetest.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * A configuration class for Spring Security. Currently, the only configuration is to disable CSRF and CORS,
 * and to allow all requests to all paths.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().cors().disable();
        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
    }

}