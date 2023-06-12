package com.alura.foro.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
	
	private final UserDetailsService userDetailsService;
	private final JWTAuthorizationFilter jwtAuthorizationFilter;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity security,
										AuthenticationManager authManager) throws Exception {
		
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		
		
		return security
					.csrf().disable()
					.authorizeHttpRequests()
					.anyRequest()
					.authenticated()
					.and()
					.httpBasic()
					.and()
					.sessionManagement()
					.sessionCreationPolicy( SessionCreationPolicy.STATELESS)
					.and()
					.addFilter(jwtAuthenticationFilter)
					.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
					.build();
	}
	
//	@Bean
//	UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("admin")
//				.password(encoder().encode("admin"))
//				.roles()
//				.build());
//		return manager;
//	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity security) throws Exception {
		return security.getSharedObject(AuthenticationManagerBuilder.class )
				.userDetailsService(userDetailsService)
				.passwordEncoder(encoder())
				.and()
				.build();
	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
