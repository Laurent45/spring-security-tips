package com.boarhat.springsecuritypractice.security.configuration;

import com.boarhat.springsecuritypractice.security.AuthenticationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class AuthenticationConfig {
    private final AuthenticationProviderService authenticationProvider;

    public AuthenticationConfig(AuthenticationProviderService authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Autowired
    void  configureAuthenticationManager(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
}
