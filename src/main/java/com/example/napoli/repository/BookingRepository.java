package com.example.napoli.repository;

import com.example.napoli.domain.entity.Booking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCarpool_CarpoolId(Long carpoolId);

}
