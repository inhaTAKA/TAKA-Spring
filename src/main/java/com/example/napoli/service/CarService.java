package com.example.napoli.service;

import com.example.napoli.domain.dto.CarCreateRequest;
import com.example.napoli.domain.entity.Car;
import com.example.napoli.domain.entity.User;
import com.example.napoli.domain.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    public void createCar(CarCreateRequest carCreateRequest) {
        Car byCarId = carRepository.findByCarId(carCreateRequest.carId());
        if (byCarId != null) {
            throw new RuntimeException("이미 존재하는 차량번호입니다.");
        }
        carRepository.save(carCreateRequest.toEntity());
    }
}
