package com.boarhat.springsecuritypractice.security;

import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class MyInMemoryUserDetailsService implements UserDetailsService {
    private final List<SecurityUser> users;

    public MyInMemoryUserDetailsService(List<SecurityUser> users) {
        this.users = users;
    }

    @Override
    public @NonNull UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(securityUser -> securityUser.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
