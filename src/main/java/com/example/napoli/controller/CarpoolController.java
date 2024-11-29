package com.example.napoli.controller;

import com.example.napoli.domain.entity.Booking;
import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.service.BookingService;
import com.example.napoli.service.Carpool.CarpoolService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/carpools")
@RequiredArgsConstructor
public class CarpoolController {

    private final CarpoolService carpoolService;
    private final BookingService bookingService;
    private final ControllerUtils controllerUtils = new ControllerUtils();

    @GetMapping("/searchCarpools")
    public String GetCarpoolSearchResults(@ModelAttribute Carpool carpool, Model model, HttpSession session) {
        if (controllerUtils.verifyUserSession(session)) {
            return "redirect:/login";
        }

        List<Carpool> searchResults = carpoolService.searchCarpool(carpool);

        if (searchResults != null) {
            model.addAttribute("carpools", searchResults);
        }

        return "/car/carList";
    }

    @GetMapping
    public String getAllCarpools(Model model, HttpSession session) {
        if (controllerUtils.verifyUserSession(session)) {
            return "redirect:/login";
        }
        List<Carpool> allCarpool = carpoolService.getAllCarpool();
        List<Boolean> isApplieds = new ArrayList<>();
        List<Boolean> isMyCarpool = new ArrayList<>();
        for (Carpool carpool : allCarpool) {
            if (carpool.getUser().getUserId() == session.getAttribute("userId")) {
                isMyCarpool.add(true);
            } else {
                isMyCarpool.add(false);
            }
            if (carpool.getBooking().isEmpty()) {
                isApplieds.add(false);
            }
            for (Booking booking : carpool.getBooking()) {
                if (booking.getUser().getUserId() == session.getAttribute("userId")) {
                    isApplieds.add(true);
                } else {
                    isApplieds.add(false);
                }
            }
        }
        Collections.reverse(allCarpool);
        Collections.reverse(isApplieds);
        Collections.reverse(isMyCarpool);

        model.addAttribute("carpools", allCarpool);
        model.addAttribute("isApplieds", isApplieds);
        model.addAttribute("isMyCarpool", isMyCarpool);
        return "/car/carList";
    }

    @PostMapping("/registerCar")
    public String registerCar(@ModelAttribute Carpool carpool, HttpSession session) {
        if (controllerUtils.verifyUserSession(session)) {
            return "redirect:/login";
        }
        Long userId = (Long) session.getAttribute("userId");
        carpoolService.saveCarpool(carpool, userId);
        return "redirect:/carpools";
    }

    @ResponseBody
    @PostMapping("/requestCarpool")
    public ResponseEntity<?> requestCarpool(@RequestBody Map<String, Object> payload, HttpSession session) {
        Long carpoolId = Long.parseLong(payload.get("carpoolId").toString());
        String phone = payload.get("phone").toString();
        String pickupLocation = payload.get("pickupLocation").toString();
        String message = payload.get("message").toString();
        Long requestUserId = (Long) session.getAttribute("userId");

        bookingService.saveBooking(carpoolId, requestUserId, phone, pickupLocation, message);

        return ResponseEntity.ok(Map.of("status", "success", "message", "Booking saved successfully."));
    }
}
