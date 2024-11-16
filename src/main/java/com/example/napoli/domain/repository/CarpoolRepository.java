package com.example.napoli.domain.repository;


import com.example.napoli.domain.entity.Carpool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarpoolRepository extends JpaRepository<Carpool, Integer> {

}
