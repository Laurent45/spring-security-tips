package com.boarhat.authorization_server.controller.dto;

public record UserOtpDTO(
        String username,
        String token
) {
}
