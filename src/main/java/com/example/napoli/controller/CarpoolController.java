package com.example.napoli.controller;

import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.entity.User;
import com.example.napoli.service.Carpool.CarpoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/carpools")
@RequiredArgsConstructor
public class CarpoolController {

    private final CarpoolService carpoolService;
    private final ControllerUtils controllerUtils = new ControllerUtils();

    @GetMapping
    public String getAllCarpools(Model model, HttpSession session) {
        if (controllerUtils.verifyUserSession(session)) {
            return "redirect:/login";
        }
        model.addAttribute("carpools", carpoolService.getAllCarpool());
       return "/car/carList";
    }

    @PostMapping("/registerCar")
    public String registerCar(@ModelAttribute Carpool carpool, HttpSession session) {
        if (controllerUtils.verifyUserSession(session)) {
            return "redirect:/login";
        }
        User user = (User) session.getAttribute("user");
        carpool.setUser(user);
        carpoolService.saveCarpool(carpool);
        return "redirect:/carpools";
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CarpoolResponseDTO> getCarpoolById(@PathVariable Long id) {
//        CarpoolResponseDTO carpool = carpoolService.getCarpoolById(id);
//        if (carpool != null) {
//            return new ResponseEntity<>(carpool, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CarpoolResponseDTO> updateCarpool(@PathVariable Long id, @RequestBody CarpoolUpdateDTO carpoolDTO) {
//        CarpoolResponseDTO updatedCarpool = carpoolService.updateCarpool(id, carpoolDTO);
//        if (updatedCarpool != null) {
//            return new ResponseEntity<>(updatedCarpool, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCarpool(@PathVariable Long id) {
//        // 카풀 삭제 서비스 호출
//        boolean isDeleted = carpoolService.deleteCarpool(id);
//        if (isDeleted) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

//    }

}
