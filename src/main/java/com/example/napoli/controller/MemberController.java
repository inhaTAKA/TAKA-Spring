package com.example.napoli.controller;

import com.example.napoli.domain.dto.UserSignUpRequest;
import com.example.napoli.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserSignUpRequest userSignUpRequest) {
        userService.signUpUser(userSignUpRequest);
        log.info("회원가입 성공");
        return "redirect:/user/login";
    }
}
