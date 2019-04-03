package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import spittr.data.SpitterRepository;
import spittr.security.SpitterUserService;
import spittr.web.SpitterRepositoryImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public SpitterRepository spitterRepository () {
		return new SpitterRepositoryImp();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth
		.userDetailsService(new SpitterUserService(spitterRepository()));
		/*.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER","ADMIN");*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.formLogin()
		.and()
		.authorizeRequests()
		.antMatchers("/spitter/me").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/spittles").access("hasRole('ADMIN')")
		.anyRequest().permitAll()
		.and()
		.requiresChannel()
		/*.antMatchers("/spitter/form")
		.requiresSecure()*/
		.antMatchers("/").requiresInsecure();
	}
}
