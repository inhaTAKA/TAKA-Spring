package com.example.napoli.controller;

import com.example.napoli.domain.dto.BookingDto;
import com.example.napoli.domain.entity.Booking;
import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.service.BookingService;
import com.example.napoli.service.Carpool.CarpoolService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        List<Carpool> searchResults = carpoolService.searchCarpools(carpool);

        if (searchResults != null) {
            Map<String, List<Boolean>> userSpecificInfo = extractUserSpecificInfo(searchResults, session);
            model.addAttribute("carpools", searchResults);
            model.addAttribute("isApplieds", userSpecificInfo.get("isApplieds"));
            model.addAttribute("isMyCarpool", userSpecificInfo.get("isMyCarpool"));

        }

        return "/car/carList";
    }

    @GetMapping
    public String getAllCarpools(Model model, HttpSession session) {
        if (controllerUtils.verifyUserSession(session)) {
            return "redirect:/login";
        }

        List<Carpool> allCarpool = carpoolService.getAllCarpool();

        // Use the extracted method
        Map<String, List<Boolean>> userSpecificInfo = extractUserSpecificInfo(allCarpool, session);

        // Reverse the lists
        Collections.reverse(allCarpool);
        Collections.reverse(userSpecificInfo.get("isApplieds"));
        Collections.reverse(userSpecificInfo.get("isMyCarpool"));

        // Add attributes to the model
        model.addAttribute("carpools", allCarpool);
        model.addAttribute("isApplieds", userSpecificInfo.get("isApplieds"));
        model.addAttribute("isMyCarpool", userSpecificInfo.get("isMyCarpool"));

        return "/car/carList";
    }

    private Map<String, List<Boolean>> extractUserSpecificInfo(List<Carpool> allCarpool, HttpSession session) {
        List<Boolean> isApplieds = new ArrayList<>();
        List<Boolean> isMyCarpool = new ArrayList<>();
        Long userId = (Long) session.getAttribute("userId");

        for (Carpool carpool : allCarpool) {
            // Check if the carpool belongs to the user
            isMyCarpool.add(carpool.getUser().getUserId().equals(userId));

            // Check if the user has applied for this carpool
            if (carpool.getBooking().isEmpty()) {
                isApplieds.add(false);
            } else {
                boolean hasApplied = carpool.getBooking().stream()
                        .anyMatch(booking -> booking.getUser().getUserId().equals(userId));
                isApplieds.add(hasApplied);
            }
        }

        Map<String, List<Boolean>> result = new HashMap<>();
        result.put("isApplieds", isApplieds);
        result.put("isMyCarpool", isMyCarpool);

        return result;
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

    @GetMapping("/bookings/{carpoolId}")
    @ResponseBody
    public ResponseEntity<List<BookingDto>> getCarpoolBookings(@PathVariable Long carpoolId) {
        List<Booking> bookings = bookingService.findBookingByCarpoolId(carpoolId);

        List<BookingDto> bookingDTOs = bookings.stream()
                .map(booking -> new BookingDto(
                        booking.getUser().getName(),
                        booking.getPhoneNumber(),
                        booking.getPickupLocation(),
                        booking.getMessage(),
                        booking.getRequestStatus()
                ))
                .toList();

        return ResponseEntity.ok(bookingDTOs);
    }
}
