package com.example.napoli.controller;

import com.example.napoli.domain.dto.UserSignUpRequest;
import com.example.napoli.domain.entity.User;
import com.example.napoli.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", UserSignUpRequest.empty());
        return "/member/login";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserSignUpRequest userSignUpRequest) {
        User user = userSignUpRequest.toEntity();
        userService.signUpUser(user);
        log.info("회원가입 성공");
        return "redirect:/login";
    }

    @PostMapping("/signIn")
    public String signInUser(@ModelAttribute UserSignUpRequest userSignUpRequest) {
        return "redirect:/";
    }
}
