package com.boarhat.springsecuritypractice.security.configuration;

import com.boarhat.springsecuritypractice.security.filter.CsrfTokenLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebSecurity
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
                .addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
                .formLogin(login -> login.defaultSuccessUrl("/main", true))
                .authorizeHttpRequests(auth -> {
                    auth.anyRequest().authenticated();
                })
                .build();
    }

}
