package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.authentication.CustomAccessDeniedHandler;
import com.example.demo.authentication.JwtAuthenticationTokenFilter;
import com.example.demo.authentication.RestAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Bean
	public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
		JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
		jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
		return jwtAuthenticationTokenFilter;
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public RestAuthenticationEntryPoint restServicesEntryPoint() {
		return new RestAuthenticationEntryPoint();
	}
	
	@Bean
	public CustomAccessDeniedHandler customAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	protected void configure(HttpSecurity http) throws Exception { 
		// disable crst cho duong dan /rest/**
		http.csrf().ignoringAntMatchers("/rest/**");
		
		http.authorizeRequests().antMatchers("/rest/login**").permitAll();
		http.authorizeRequests().antMatchers("/rest/profile**").permitAll();
		http.authorizeRequests().antMatchers("/rest/user**").permitAll();

		http.antMatcher("/rest/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
			.antMatchers(HttpMethod.GET, "/rest/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')  or hasRole('ROLE_STUDENT') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
			.antMatchers(HttpMethod.POST, "/rest/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')  or hasRole('ROLE_STUDENT') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
			.antMatchers(HttpMethod.DELETE, "/rest/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_HEAD')")
			.antMatchers(HttpMethod.PUT, "/rest/user**").access("hasRole('ROLE_USER')")
			.and().addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
			.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
//
//		http.antMatcher("/rest/join**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/rest/join**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER') or hasRole('ROLE_STUDENT') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
//				.antMatchers(HttpMethod.POST, "/rest/join**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
//				.antMatchers(HttpMethod.DELETE, "/rest/join**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_HEAD')")
//				.antMatchers(HttpMethod.PUT, "/rest/join**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
//				.and().addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
//				.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
//
//		http.antMatcher("/rest/topic**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/rest/topic**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER') or hasRole('ROLE_STUDENT') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
//				.antMatchers(HttpMethod.POST, "/rest/topic**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
//				.antMatchers(HttpMethod.DELETE, "/rest/topic**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_HEAD')")
//				.antMatchers(HttpMethod.PUT, "/rest/topic**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
//				.and().addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
//				.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
//
//		http.antMatcher("/rest/department**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/rest/department**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER') or hasRole('ROLE_STUDENT') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
//				.antMatchers(HttpMethod.POST, "/rest/department**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers(HttpMethod.DELETE, "/rest/department**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers(HttpMethod.PUT, "/rest/department**").access("hasRole('ROLE_ADMIN')")
//				.and().addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
//				.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
//
//		http.antMatcher("/rest/instructor**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/rest/instructor**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER') or hasRole('ROLE_STUDENT') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
//				.antMatchers(HttpMethod.POST, "/rest/instructor**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers(HttpMethod.DELETE, "/rest/instructor**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers(HttpMethod.PUT, "/rest/instructor**").access("hasRole('ROLE_ADMIN')")
//				.and().addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
//				.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
//
//		http.antMatcher("/rest/student**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/rest/student**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER') or hasRole('ROLE_STUDENT') or hasRole('ROLE_INSTRUCTOR')or hasRole('ROLE_HEAD')")
//				.antMatchers(HttpMethod.POST, "/rest/student**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers(HttpMethod.DELETE, "/rest/student**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers(HttpMethod.PUT, "/rest/student**").access("hasRole('ROLE_ADMIN')")
//				.and().addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
//				.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
//
//		http.antMatcher("/rest/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//			.antMatchers(HttpMethod.GET, "/rest/**").access("hasRole('ROLE_ADMIN')")
//			.antMatchers(HttpMethod.POST, "/rest/**").access("hasRole('ROLE_ADMIN')")
//			.antMatchers(HttpMethod.DELETE, "/rest/**").access("hasRole('ROLE_ADMIN')")
//			.antMatchers(HttpMethod.PUT, "/rest/user**").access("hasRole('ROLE_ADMIN')")
//			.and().addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
//			.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
	}
}
