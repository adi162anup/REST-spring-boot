package com.adi.moviedemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration()
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails sarfaraz = User.builder()
                .username("sarfaraz")
                .password("{noop}khan123")
                .roles("EMPLOYEE")
                .build();

        UserDetails rohit = User.builder()
                .username("rohit")
                .password("sharma123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails rahul = User.builder()
                .username("rahul")
                .password("dravid123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(sarfaraz,rohit,rahul);
    }
}
