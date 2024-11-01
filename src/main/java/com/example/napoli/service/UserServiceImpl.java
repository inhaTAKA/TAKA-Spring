package com.example.napoli.service;

import com.example.napoli.domain.dto.UserSignUpRequest;
import com.example.napoli.domain.entity.User;
import com.example.napoli.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void signUpUser(UserSignUpRequest userSignUpRequest) {
        User byEmail = userRepository.findByEmail(userSignUpRequest.email());
        if(byEmail != null) {
            throw new RuntimeException("이미 존재하는 이메일입니다");
        }
        User byPhone = userRepository.findByPhoneNumber(userSignUpRequest.phoneNumber());
        if(byPhone != null) {
            throw new RuntimeException("이미 존재하는 휴대폰 번호입니다.");
        }
        userRepository.save(userSignUpRequest.toEntity(userSignUpRequest));
    }

}
