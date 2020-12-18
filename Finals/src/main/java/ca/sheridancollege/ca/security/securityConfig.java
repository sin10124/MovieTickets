package ca.sheridancollege.ca.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception
	{
		auth
		.inMemoryAuthentication()
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("akash").password("buttar").roles("USER");
	}

}
