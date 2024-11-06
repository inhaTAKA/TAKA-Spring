package com.example.napoli.domain.repository;

import com.example.napoli.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
    Car findByCarId(Long carId);
}
