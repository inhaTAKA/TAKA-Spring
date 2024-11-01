package com.example.napoli.domain.dto;

public record UserLoginRequest(
        String email,
        String phoneNumber
) {
}
