package com.example.napoli.domain.dto;


import com.example.napoli.domain.entity.User;

import java.time.LocalDate;

public record UserSignUpRequest(
        String username,
        String password,
        String gender,
        //얘는 지워야하는데 지우면 에러가 뜸
        String email,
        String confirmPassword
) {

    public static UserSignUpRequest empty() {
        //얘도 confrimPassword지워지면 같이 수정필요할듯
        return new UserSignUpRequest(null, null, null, null, null);
    }

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .gender(gender)
                .email(email)
                .createdAt(LocalDate.now())
                .build();
    }
}
