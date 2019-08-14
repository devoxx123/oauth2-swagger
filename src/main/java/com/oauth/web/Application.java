package com.oauth.web;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oauth.web.config.CustomUserDetails;
import com.oauth.web.repositories.UserRepositroy;
import com.oauth.web.services.UserService;

@SpringBootApplication
@EnableCaching
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    } 

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	DataSource dataSource;

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepositroy repository,
			UserService service) throws Exception {
		builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
				.usersByUsernameQuery("SELECT username,password,1 AS enabled FROM user WHERE username=?")
				.authoritiesByUsernameQuery(
						"SELECT u.username AS username, r.name AS role FROM user u ,role r, user_roles ur WHERE u.id=ur.user_id AND r.id=ur.roles_id AND u.username=?");
		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);

	}

	private UserDetailsService userDetailsService(final UserRepositroy repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}

}
