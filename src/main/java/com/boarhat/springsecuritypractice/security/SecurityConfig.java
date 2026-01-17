package com.boarhat.springsecuritypractice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class SecurityConfig {

    @Autowired
    public void configure(AuthenticationManagerBuilder builder, AuthenticationProvider authenticationProvider) {
        builder.authenticationProvider(authenticationProvider)
                .eraseCredentials(false);
    }

}
