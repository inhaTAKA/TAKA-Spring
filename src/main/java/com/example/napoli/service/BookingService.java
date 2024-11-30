package com.example.napoli.service;

import com.example.napoli.domain.entity.Booking;
import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.entity.User;
import com.example.napoli.domain.repository.BookingRepository;
import com.example.napoli.domain.repository.CarpoolRepository;
import com.example.napoli.domain.repository.UserRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarpoolRepository carpoolRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveBooking(Long carpoolId, Long requestUserId, String phone, String pickupLocation, String message) {
        Carpool carpool = carpoolRepository.findById(carpoolId).orElse(null);
        User user = userRepository.findById(requestUserId).orElse(null);

        Booking booking = Booking.builder()
                .user(user)
                .carpool(carpool)
                .phoneNumber(phone)
                .pickupLocation(pickupLocation)
                .message(message)
                .bookingTime(LocalDate.now())
                .requestStatus(false)
                .build();

        bookingRepository.save(booking);
    }

    public List<Booking> findBookingByCarpoolId(Long carpoolId) {
        return bookingRepository.findByCarpool_CarpoolId(carpoolId);
    }
}
