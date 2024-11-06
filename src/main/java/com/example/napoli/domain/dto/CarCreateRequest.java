package com.example.napoli.domain.dto;

import com.example.napoli.domain.entity.Car;
import com.example.napoli.domain.entity.User;

import java.time.LocalDate;

public record CarCreateRequest(
    User user,
    String carId,
    String model,
    String carStatus
) {
    public Car toEntity() {
        return Car.builder()
                .user(user)
                .carId(carId)
                .model(model)
                .carStatus(carStatus)
                .build();
    }
}
