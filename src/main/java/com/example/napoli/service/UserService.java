package com.example.napoli.service;

import com.example.napoli.domain.dto.UserSignUpRequest;
import com.example.napoli.domain.entity.Booking;
import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.entity.User;
import com.example.napoli.repository.BookingRepository;
import com.example.napoli.repository.CarpoolRepository;
import com.example.napoli.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final CarpoolRepository carpoolRepository;

    @Transactional
    public void signUpUser(UserSignUpRequest userRequest) {
        User findUser = userRepository.findUserByUsername(userRequest.username());
        if (findUser != null) {
            throw new RuntimeException("이미 존재하는 이름입니다.");
        }
        userRepository.save(userRequest.toEntity());
    }

    public User signInUser(String username, String password) {
        User findUser = userRepository.findUserByUsername(username);
        if (findUser == null || !findUser.getPassword().equals(password)) {
            throw new RuntimeException("존재하지 않는 계정입니다.");
        }
        return findUser;
    }

    public User findByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Transactional
    public void acceptCarpoolRequest(Long carpoolId, Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        optionalBooking.ifPresent(booking -> booking.setRequestStatus(true));

        Optional<Carpool> optionalCarpool = carpoolRepository.findById(carpoolId);
        optionalCarpool.ifPresent(carpool -> carpool.setRestSeat(carpool.getRestSeat() - 1));
    }
}
