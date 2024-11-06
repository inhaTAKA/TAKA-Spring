package com.example.napoli.controller;

import com.example.napoli.domain.dto.RegisterCarDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarpoolController {

    @GetMapping("/carList")
    public String carList(){
        return "/car/carList";
    }

    @PostMapping("/registerCar")
    public String registerCar(@ModelAttribute RegisterCarDto registerCarDto) {
        System.out.println(registerCarDto.toString());
        return "redirect:/carList";
    }
}
