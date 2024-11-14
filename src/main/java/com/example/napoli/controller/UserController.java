package com.example.napoli.controller;

import com.example.napoli.domain.dto.UserSignUpRequest;
import com.example.napoli.domain.entity.User;
import com.example.napoli.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", UserSignUpRequest.empty());
        return "/member/login";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserSignUpRequest userSignUpRequest,
                               @RequestParam("actionType") String actionType,
                               HttpSession session) {
        if ("signup".equals(actionType)) {
            try {
                userService.signUpUser(userSignUpRequest);
            } catch (RuntimeException e) {
                log.error(e.getMessage());
                return "redirect:/login";
            }
            log.info("회원가입 성공");
            return "redirect:/login";
        } else if ("signin".equals(actionType)) {
            try {
                User user = userService.signInUser(userSignUpRequest.username(), userSignUpRequest.password());
                // 세션에 정보 저장
                session.setAttribute("user", user);
            } catch (Exception e) {
                log.error(e.getMessage());
                return "redirect:/login";
            }
//            User sessionUser = (User) session.getAttribute("user");
//            log.info(sessionUser.getUsername());
            log.info("로그인 성공");
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
