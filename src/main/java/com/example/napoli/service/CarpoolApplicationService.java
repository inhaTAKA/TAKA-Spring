package com.example.napoli.service;

import com.example.napoli.entity.CarpoolApplication;
import com.example.napoli.domain.repository.CarpoolApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarpoolApplicationService {

    private final CarpoolApplicationRepository carpoolApplicationRepository;

    @Autowired
    public CarpoolApplicationService(CarpoolApplicationRepository carpoolApplicationRepository) {
        this.carpoolApplicationRepository = carpoolApplicationRepository;
    }

    public CarpoolApplication applyToCarpool(CarpoolApplication carpoolApplication) {
        return carpoolApplicationRepository.save(carpoolApplication);
    }
}
