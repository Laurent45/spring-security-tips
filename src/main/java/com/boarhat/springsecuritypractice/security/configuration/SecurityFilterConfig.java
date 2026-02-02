package com.boarhat.springsecuritypractice.security.configuration;

import com.boarhat.springsecuritypractice.security.filter.RequestValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
                .addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
/*                .formLogin(formLogin -> {
                    formLogin.defaultSuccessUrl("/main", true);
                })
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.anyRequest().authenticated();
                })*/
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .build();
    }
}
