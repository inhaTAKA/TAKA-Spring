package com.example.napoli.domain.repository;


import com.example.napoli.domain.entity.Carpool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarpoolRepository extends JpaRepository<Carpool, Long> {
    List<Carpool> findByStartLocationContainingAndEndLocationContainingAndMinDesiredChargeGreaterThanEqualAndMaxDesiredChargeLessThanEqualAndSex(
            String startLocation,
            String endLocation,
            int minCharge,
            int maxCharge,
            String sex
    );
}