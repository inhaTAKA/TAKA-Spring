package com.example.napoli.service.Carpool;

import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.repository.CarpoolRepository;
import com.example.napoli.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CarpoolService {

    private final CarpoolRepository carpoolRepository;
    private final UserRepository userRepository;

    public void saveCarpool(Carpool carpool, Long userId) {
        userRepository.findById(userId).ifPresent(carpool::setUser);
        carpoolRepository.save(carpool);
    }

    public Carpool findCarpoolById(Long id) {
        return carpoolRepository.findById(id).orElse(null);
    }

    public List<Carpool> getAllCarpool() {
        return carpoolRepository.findAll();
    }

    public boolean deleteCarpool(Long id) {
        Optional<Carpool> carpool = carpoolRepository.findById(id);

        if (carpool.isPresent()) {
            carpoolRepository.delete(carpool.get());
            return true;
        }

        return false;
    }

    public List<Carpool> searchCarpool(Carpool carpool) {
        return carpoolRepository.findByStartLocationContainingAndEndLocationContainingAndMinDesiredChargeGreaterThanEqualAndMaxDesiredChargeLessThanEqualAndSex(
                carpool.getStartLocation(),
                carpool.getEndLocation(),
                carpool.getMinDesiredCharge(),
                carpool.getMaxDesiredCharge(),
                carpool.getSex()
        );
    }

}
