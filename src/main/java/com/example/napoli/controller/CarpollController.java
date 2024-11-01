package com.example.napoli.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class CarpollController {
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

}
