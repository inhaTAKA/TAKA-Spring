package com.example.napoli.service.Carpool;

import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.repository.CarpoolRepository;
import com.example.napoli.domain.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarpoolService {

    private final CarpoolRepository carpoolRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveCarpool(Carpool carpool, Long userId) {
        userRepository.findById(userId).ifPresent(carpool::setUser);
        carpoolRepository.save(carpool);
    }

    public Carpool findCarpoolById(Long id) {
        return carpoolRepository.findCarpoolByCarpoolId(id);
    }

    public List<Carpool> getAllCarpool() {
        return carpoolRepository.findAll();
    }
}
