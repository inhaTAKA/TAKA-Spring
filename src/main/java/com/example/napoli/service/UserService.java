package com.example.napoli.service;

import com.example.napoli.domain.dto.UserSignUpRequest;
import com.example.napoli.domain.entity.User;
import com.example.napoli.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signUpUser(UserSignUpRequest userRequest) {
        User findUser = userRepository.findUserByUsername(userRequest.username());
        if (findUser != null) {
            throw new RuntimeException("이미 존재하는 이름입니다.");
        }
        userRepository.save(userRequest.toEntity());
    }

    public User signInUser(String username, String password) {
        User findUser = userRepository.findUserByUsername(username);
        if (findUser == null || !findUser.getPassword().equals(password)) {
            throw new RuntimeException("존재하지 않는 계정입니다.");
        }
        return findUser;
    }

    public User findByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
