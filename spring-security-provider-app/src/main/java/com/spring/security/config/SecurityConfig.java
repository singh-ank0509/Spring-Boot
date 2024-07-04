package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
           .authorizeHttpRequests((authorize) -> authorize
               .anyRequest().authenticated()
            )
           .httpBasic();
        return http.build();
    }
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
           .username("ankur")
           .password("ankur@123")
           .roles("ADMIN")
           .build();
        
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("singh")
                .password("singh@123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}