package com.example.napoli.controller;

import com.example.napoli.domain.dto.RegisterCarDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String getHome(Model model) {
        model.addAttribute("carInfo", new RegisterCarDto(null, null,
                null, null,
                null, null,
                null, null,
                0, 0,
                null));
        return "home";
    }
}
