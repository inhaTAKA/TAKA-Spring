package com.example.napoli.service.Carpool;

import com.example.napoli.domain.entity.CarpoolVer2;
import com.example.napoli.domain.repository.CarpoolVer2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarpoolVer2Service {

    private final CarpoolVer2Repository repository;

    public void saveCarpool(CarpoolVer2 carpoolVer2) {
        repository.save(carpoolVer2);
    }
}
