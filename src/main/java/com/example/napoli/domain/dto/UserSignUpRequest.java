package com.example.napoli.domain.dto;


import com.example.napoli.domain.entity.User;

import java.time.LocalDate;

public record UserSignUpRequest(
        String username,
        String password,
        String confirmPassword
) {

    public static UserSignUpRequest empty() {
        return new UserSignUpRequest(null, null, null);
    }

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .createdAt(LocalDate.now())
                .build();
    }
}
