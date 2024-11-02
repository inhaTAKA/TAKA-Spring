package com.example.napoli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarpoolController {

    @GetMapping("/carList")
    public String carList(){
        return "/car/carList";
    }

}
