package com.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
@Autowired
UserDetailsService userDetailsService;	
	
@Override
//Authentication
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// TODO Auto-generated method stub
	super.configure(auth);
}

// Authorization
@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable()
    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
   .and()
   .authorizeRequests()
   .antMatchers("/auth/**")       
   .permitAll()
   .antMatchers("/images/{fileName}")       
   .permitAll()   
   .antMatchers("/blog/posts")
   .permitAll()
   .antMatchers("/blog/posts/{id}")
   .permitAll()   
   .antMatchers("/blog/testblog")
   .permitAll()   
   .anyRequest()
   .authenticated();
   //.and()
   //.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
 
}
