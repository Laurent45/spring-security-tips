package com.boarhat.springsecuritypractice.user;


import java.util.Objects;

public class MyUser {
    private final String username;
    private final String password;
    private final String authority;

    public MyUser(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyUser myUser)) return false;
        return Objects.equals(username, myUser.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
