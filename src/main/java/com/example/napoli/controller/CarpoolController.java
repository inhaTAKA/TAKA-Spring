package com.example.napoli.controller;

import com.example.napoli.domain.dto.UserSignUpRequest;
import com.example.napoli.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CarpoolController {

    private final UserService userService;

    @RequestMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/carList")
    public String carList(){
        return "/car/carList";
    }

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
