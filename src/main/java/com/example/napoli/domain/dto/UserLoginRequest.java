package com.example.napoli.domain.dto;

public record UserLoginRequest(
        String username,
        String password
) {
}
