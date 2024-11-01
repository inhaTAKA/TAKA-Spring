package com.example.napoli.domain.repository;

import com.example.napoli.entity.Carpool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarpoolRepository extends JpaRepository<Carpool, Long> {
}
