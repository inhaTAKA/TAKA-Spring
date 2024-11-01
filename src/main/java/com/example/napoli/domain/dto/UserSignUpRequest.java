package com.example.napoli.domain.dto;

import java.time.LocalDate;

public record UserSignUpRequest(
        Long userId,
        String email,
        String password,
        String className,
        String grade,
        LocalDate createdAt
) {

}
