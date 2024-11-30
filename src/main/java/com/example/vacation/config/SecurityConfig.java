package com.example.vacation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests( auth -> auth
                		.requestMatchers("/").permitAll()
                		.requestMatchers("/contact").permitAll()
						.requestMatchers("/products", "/products/", "/products/index").permitAll() // Allow index.html
						.requestMatchers("/products/view/**").permitAll()
						.requestMatchers("/products/search/**").permitAll()
	                    .requestMatchers("/register").permitAll()
	                    .requestMatchers("/login").permitAll()
	                    .requestMatchers("/logout").permitAll()
//	                    .requestMatchers("/client/**").hasRole("client")
//	                    .requestMatchers("/admin/**").hasRole("admin")
	                    .requestMatchers("/images/**").permitAll() // Allow access to images
	                    .anyRequest().authenticated()
                )
                .formLogin(form -> form
                		.loginPage("/login")
                		.usernameParameter("email")
                		.passwordParameter("password")
                		.defaultSuccessUrl("/products", true)
                )
                .logout(config -> config.logoutSuccessUrl("/"))
        		.build();
    }
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}































