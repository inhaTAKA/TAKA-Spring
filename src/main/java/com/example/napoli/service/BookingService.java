package com.example.napoli.service;

import com.example.napoli.domain.entity.Booking;
import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.entity.User;
import com.example.napoli.domain.repository.BookingRepository;
import com.example.napoli.domain.repository.CarpoolRepository;
import com.example.napoli.domain.repository.UserRepository;
import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarpoolRepository carpoolRepository;
    private final UserRepository userRepository;

    public void saveBooking(Long carpoolId, Long userId) {
        Carpool carpool = carpoolRepository.findById(carpoolId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        Booking booking = Booking.builder()
                .user(user)
                .carpool(carpool)
                .bookingTime(LocalDate.now())
                .approvalStatus(false)
                .build();

        bookingRepository.save(booking);
    }
}
