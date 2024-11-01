package com.example.napoli.domain.dto;


import com.example.napoli.domain.entity.User;

import java.time.LocalDate;

public record UserSignUpRequest(
        String name,
        String email,
        String phoneNumber,
        String password,
        String className,
        Long grade
) {
    public User toEntity(UserSignUpRequest userSignUpRequest) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .className(className)
                .grade(grade)
                .createdAt(LocalDate.now())
                .build();
    }
}
