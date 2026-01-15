package com.boarhat.springsecuritypractice.security;

import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder implements PasswordEncoder {
    @Override
    public @Nullable String encode(@Nullable CharSequence rawPassword) {
        return rawPassword != null ? rawPassword.toString() : null;
    }

    @Override
    public boolean matches(@Nullable CharSequence rawPassword, @Nullable String encodedPassword) {
        return rawPassword != null && rawPassword.toString().equals(encodedPassword);
    }
}
