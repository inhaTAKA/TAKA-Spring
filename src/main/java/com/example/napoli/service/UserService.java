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
        User username = userRepository.findUserByUsername(userRequest.username());
        if (username != null) {
            throw new RuntimeException("이미 존재하는 아이디입니다");
        } else if (!userRequest.password().equals(userRequest.confirmPassword())) {
            throw new RuntimeException("비밀번호와 확인 비밀번호가 일치하지 않습니다.");
        }
        User user = User.builder()
                .username(userRequest.username())
                .password(userRequest.password())
                .build();

        userRepository.save(user);
    }

    public void signInUser(String username, String password) {
        User findUser = userRepository.findUserByUsername(username);
        if (findUser == null || !findUser.getPassword().equals(password)) {
            throw new RuntimeException("존재하지 않는 계정입니다.");
        }
    }

}
