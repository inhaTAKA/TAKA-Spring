package com.example.napoli.service.Carpool;

import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.repository.CarpoolRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarpoolService {

    private final CarpoolRepository repository;

    public void saveCarpool(Carpool carpool) {
        repository.save(carpool);
    }

    public List<Carpool> getAllCarpool() {
        return repository.findAll();
    }
}
