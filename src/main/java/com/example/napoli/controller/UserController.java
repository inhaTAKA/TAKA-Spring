package com.example.napoli.controller;

import com.example.napoli.domain.dto.UserSignUpRequest;
import com.example.napoli.domain.entity.Booking;
import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.entity.User;
import com.example.napoli.service.BookingService;
import com.example.napoli.service.Carpool.CarpoolService;
import com.example.napoli.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BookingService bookingService;
    private final CarpoolService carpoolService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", UserSignUpRequest.empty());
        return "/user/login";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserSignUpRequest userSignUpRequest,
                               @RequestParam("actionType") String actionType,
                               HttpSession session) {
        if ("signup".equals(actionType)) {
            try {
                userService.signUpUser(userSignUpRequest);
            } catch (RuntimeException e) {
                log.error(e.getMessage());
                return "redirect:/login";
            }
            log.info("회원가입 성공");
            return "redirect:/login";
        } else if ("signin".equals(actionType)) {
            try {
                User user = userService.signInUser(userSignUpRequest.username(), userSignUpRequest.password());
                // 세션에 정보 저장
                session.setAttribute("userId", user.getUserId());
                session.setAttribute("loggedInUser", user.getUsername());
            } catch (Exception e) {
                log.error(e.getMessage());
                return "redirect:/login";
            }
            log.info("로그인 성공");
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/myCarpoolRequest")
    public String myCarpool(HttpSession session, Model model) {
        User user = userService.findByUserId((Long) session.getAttribute("userId"));
        List<Carpool> userCarPools = user.getCarPools();
        if (userCarPools.isEmpty()) {
            return "/user/myPage";
        }
        List<Booking> filterBookings = userCarPools.stream()
                .flatMap(carpool -> carpool.getBooking().stream()
                        .filter(booking -> !booking.getRequestStatus()))
                        .toList();

        model.addAttribute("bookings", filterBookings);
        model.addAttribute("userName", user.getUsername());
        return "/user/myPage";
    }

    @PostMapping("/carpoolRequest/{bookingId}/{carpoolId}/accept")
    public String carpoolRequestAccept(@PathVariable("bookingId") Long bookingId, @PathVariable("carpoolId") Long carpoolId) {
        userService.acceptCarpoolRequest(carpoolId, bookingId);
        return "redirect:/myCarpoolRequest";
    }

    @GetMapping("/carpools/myCarpools") // 내 카풀 목록 페이지 경로 추가
    public String myCarpoolsPage(Model model, HttpSession session) throws Exception{
        User user = userService.findByUserId((Long) session.getAttribute("userId"));
        List<Carpool> carpools = user.getCarPools();

        model.addAttribute("carpools", carpools);

        return "/car/myCarpools"; // 'templates/car/myCarpools.html' 반환
    }
}
