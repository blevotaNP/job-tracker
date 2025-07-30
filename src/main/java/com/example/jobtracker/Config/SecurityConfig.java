package com.example.jobtracker.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                //clears default security
                .csrf(csrf -> csrf.disable())

                //every user must be authorized
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                //enables <iframe> (for h2)
                .headers(headers -> headers
                        .frameOptions(frame -> frame.disable()))

                //enables the default form login for browser
                .formLogin(Customizer.withDefaults())

                //enables for REST API access (Postman)
                .httpBasic(Customizer.withDefaults())

                //makes sessionID stateless
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("qwe")
                .password("123")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager();
    }

}
