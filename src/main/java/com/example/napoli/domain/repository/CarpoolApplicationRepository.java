package com.example.napoli.domain.repository;

import com.example.napoli.entity.CarpoolApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarpoolApplicationRepository extends JpaRepository<CarpoolApplication, Long> {
}
