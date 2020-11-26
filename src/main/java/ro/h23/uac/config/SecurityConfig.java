package ro.h23.uac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// {noop} - password storage format, for plain text
		auth.inMemoryAuthentication().withUser("admin").password("{noop}12345").roles("ADMIN", "USER")
		.and()
		.withUser("ana").password("{noop}mere").roles("USER");
	}
	
	/*
	 * Alternative to the configureGlobal method from above
	 * !!! the User class is from org.springframework.security.core.userdetails
	@Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("admin").password("12345").roles("ADMIN", "USER").build());
        manager.createUser(users.username("ana").password("mere").roles("USER").build());
        return manager;
    }
    */
}