package com.example.napoli;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class carController {
    @GetMapping("/carList")
    public String carList(){
        return "/car/carList";
    }
}
