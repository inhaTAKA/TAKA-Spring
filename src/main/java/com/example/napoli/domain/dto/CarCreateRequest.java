package com.example.napoli.domain.dto;

import com.example.napoli.domain.entity.User;

public record CarCreateRequest(
    User user,
    String carId,
    String model,
    String carStatus
) {
}
