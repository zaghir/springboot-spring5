package com.zaghir.project.todo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

// si on veut faire l'authentification simple ,il faut enlever le commentaire de @Configuration   
//@Configuration
public class ToDoSecurityConfig extends WebSecurityConfigurerAdapter{

	private final Logger log = LoggerFactory.getLogger(ToDoSecurityConfig.class);
	
	//Use this to connect to the Directory App
	private RestTemplate restTemplate;
	private ToDoProperties toDoProperties;
	private UriComponentsBuilder builder;
	
	public ToDoSecurityConfig(
			RestTemplateBuilder restTemplateBuilder,
			ToDoProperties toDoProperties){
		this.toDoProperties = toDoProperties;
		this.restTemplate = restTemplateBuilder.basicAuthentication(toDoProperties.getUsername(),toDoProperties.getPassword()).build();
			}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.passwordEncoder(passwordEncoder())
			.withUser("sa")
			.password(passwordEncoder().encode("sa"))
			.roles("ADMIN","USER");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.requestMatchers(
						PathRequest
							.toStaticResources()
								.atCommonLocations())
				.permitAll()
				.anyRequest().fullyAuthenticated()
				.and()
					.formLogin().loginPage("/login").permitAll()
				.and()
					.logout()	
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/login")
				.and()
					.httpBasic();
	}
	
}
