package com.boarhat.authorization_server.controller.dto;

public record UserCreateDTO(
        String username,
        String password
) {
}
