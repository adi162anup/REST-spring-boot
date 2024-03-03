package com.adi.moviedemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
                .password("{noop}sharma123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails rahul = User.builder()
                .username("rahul")
                .password("{noop}dravid123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(sarfaraz,rohit,rahul);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/theatres").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/theatres/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/theatres").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/theatres").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/theatres/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
