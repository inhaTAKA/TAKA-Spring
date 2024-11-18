package com.example.napoli.controller;

import com.example.napoli.domain.entity.Booking;
import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.service.BookingService;
import com.example.napoli.service.Carpool.CarpoolService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private final BookingService bookingService;
    private final ControllerUtils controllerUtils = new ControllerUtils();

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
    public Map<String, String> requestCarpool(@RequestBody Map<String, Object> payload, HttpSession session) {
        Long carpoolId = Long.parseLong(payload.get("carpoolId").toString());
        Long requestUserId = (Long) session.getAttribute("userId");

        bookingService.saveBooking(carpoolId, requestUserId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "카풀 신청이 완료되었습니다!");

        return response;
    }
}
