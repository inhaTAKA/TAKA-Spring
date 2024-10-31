package com.example.napoli.service;

import com.example.napoli.entity.Carpool;
import com.example.napoli.repository.CarpoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarpoolService {

    private final CarpoolRepository carpoolRepository;

    @Autowired
    public CarpoolService(CarpoolRepository carpoolRepository) {
        this.carpoolRepository = carpoolRepository;
    }

    public Carpool createCarpool(Carpool carpool) {
        return carpoolRepository.save(carpool);
    }

    public List<Carpool> getAvailableCarpools() {
        return carpoolRepository.findAll();
    }
}
