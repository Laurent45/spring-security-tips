package com.boarhat.springsecuritypractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain http(HttpSecurity http) {
        return http
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/admin").authenticated()
                                .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Autowired
    protected void authenticationManager(AuthenticationManagerBuilder auth) {
        var userDetailsService = new InMemoryUserDetailsManager();
        var passwordEncoder = NoOpPasswordEncoder.getInstance();

        var user = User.withUsername("user")
                .password("password")
                .authorities("read")
                .build();
        userDetailsService.createUser(user);

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
