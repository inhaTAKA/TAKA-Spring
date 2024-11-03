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
    public void signUpUser(User user) {
        User byEmail = userRepository.findByUsername(user.getUsername());
        if(byEmail != null) {
            throw new RuntimeException("이미 존재하는 아이디입니다");
        }
        userRepository.save(user);
    }

    @Override
    public void signInUser(User user) {

    }

}
