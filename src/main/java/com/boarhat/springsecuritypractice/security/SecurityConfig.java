package com.boarhat.springsecuritypractice.security;

import com.boarhat.springsecuritypractice.user.MyUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        MyUser myUser = new MyUser("Bill", "password", "read");
        SecurityUser securityUser = new SecurityUser(myUser);
        List<SecurityUser> users = List.of(securityUser);

        return new MyInMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
