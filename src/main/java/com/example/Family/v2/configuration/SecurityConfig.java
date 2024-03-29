package com.example.Family.v2.configuration;

import com.example.Family.v2.components.AuthenticationTokenFilter;
import com.example.Family.v2.constants.AuthorityName;
import com.example.Family.v2.constants.properties.JwtProperties;
import com.example.Family.v2.services.impl.CustomUserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	private final JwtProperties jwtProperties;

	public SecurityConfig(UserDetailsService userDetailsService, RestAuthenticationEntryPoint restAuthenticationEntryPoint, JwtProperties jwtProperties) {
		this.userDetailsService = userDetailsService;
		this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
		this.jwtProperties = jwtProperties;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureAuthenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
			.csrf().disable()
			.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.addFilter(new AuthenticationTokenFilter(jwtProperties, authenticationManagerBean()))
			.authorizeRequests()
			.antMatchers(HttpMethod.GET).permitAll()
			.antMatchers("/auth/login").permitAll()//permito el acceso a la ruta a TODOS
			.antMatchers(HttpMethod.DELETE).hasAuthority(AuthorityName.ROLE_ADMIN.toString())
			.anyRequest().hasAnyAuthority(AuthorityName.ROLE_USER.toString(),
										 AuthorityName.ROLE_ADMIN.toString());


	}

}
