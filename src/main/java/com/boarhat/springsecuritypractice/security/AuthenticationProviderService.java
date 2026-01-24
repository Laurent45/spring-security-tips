package com.boarhat.springsecuritypractice.security;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationProviderService implements AuthenticationProvider {

    private final JpaUserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Pbkdf2PasswordEncoder pbkdf2PasswordEncoder;

    public AuthenticationProviderService(JpaUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, Pbkdf2PasswordEncoder pbkdf2PasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.pbkdf2PasswordEncoder = pbkdf2PasswordEncoder;
    }


    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = Objects.requireNonNullElse(authentication.getCredentials(), "").toString();

        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

        boolean isValidPassword = switch (userDetails.getEncryptionAlgorithm()) {
            case BCRYPT -> bCryptPasswordEncoder.matches(password, userDetails.getPassword());
            case PBKDF2 -> pbkdf2PasswordEncoder.matches(password, userDetails.getPassword());
        };

        if (!isValidPassword) {
            throw new BadCredentialsException("Invalid username or password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(@NonNull Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
