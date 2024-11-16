package com.example.napoli.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("loggedInUser")
    public String getLoggedInUser(HttpSession session) {
        return (String) session.getAttribute("loggedInUser"); // 세션에서 사용자 정보 가져오기
    }
}