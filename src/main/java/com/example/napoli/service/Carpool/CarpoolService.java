package com.example.napoli.service.Carpool;

import com.example.napoli.domain.dto.Carpool.CarpoolResponseDTO;
import com.example.napoli.domain.dto.Carpool.CarpoolUpdateDTO;
import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.entity.User;
import com.example.napoli.domain.entity.Car;
import com.example.napoli.domain.repository.CarpoolRepository;
import com.example.napoli.domain.repository.UserRepository;
import com.example.napoli.domain.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarpoolService {

    private final CarpoolRepository carpoolRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Autowired
    public CarpoolService(CarpoolRepository carpoolRepository, UserRepository userRepository, CarRepository carRepository) {
        this.carpoolRepository = carpoolRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    public CarpoolResponseDTO createCarpool(CarpoolUpdateDTO carpoolUpdateDTO) {
        Optional<User> userOptional = userRepository.findById(carpoolUpdateDTO.getUserId());
        Optional<Car> carOptional = carRepository.findById(carpoolUpdateDTO.getCarId());

        if (!userOptional.isPresent() || !carOptional.isPresent()) {
            return new CarpoolResponseDTO();
        }

        User user = userOptional.get();
        Car car = carOptional.get();

        Carpool carpool = Carpool.builder()
                .user(user)
                .car(car)
                .departureLocation(carpoolUpdateDTO.getDepartureLocation())
                .arrivalLocation(carpoolUpdateDTO.getArrivalLocation())
                .departureTime(carpoolUpdateDTO.getDepartureTime())
                .arrivalTime(carpoolUpdateDTO.getArrivalTime())
                .bookingStatus(carpoolUpdateDTO.getBookingStatus())
                .availableSeats(carpoolUpdateDTO.getAvailableSeats())
                .build();

        carpool = carpoolRepository.save(carpool);

        return convertToResponseDTO(carpool);
    }

    public List<CarpoolResponseDTO> getAllCarpools() {
        List<Carpool> carpools = carpoolRepository.findAll();
        return carpools.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public CarpoolResponseDTO updateCarpool(Long carpoolId, CarpoolUpdateDTO carpoolUpdateDTO) {
        Optional<Carpool> existingCarpoolOptional = carpoolRepository.findById(carpoolId);

        if (!existingCarpoolOptional.isPresent()) {
            return null;
        }

        Carpool existingCarpool = existingCarpoolOptional.get();

//        if (carpoolUpdateDTO.getDepartureLocation() != null) {
//            existingCarpool.setDepartureLocation(carpoolUpdateDTO.getDepartureLocation());
//        }
//        if (carpoolUpdateDTO.getArrivalLocation() != null) {
//            existingCarpool.setArrivalLocation(carpoolUpdateDTO.getArrivalLocation());
//        }
//        if (carpoolUpdateDTO.getDepartureTime() != null) {
//            existingCarpool.setDepartureTime(carpoolUpdateDTO.getDepartureTime());
//        }
//        if (carpoolUpdateDTO.getArrivalTime() != null) {
//            existingCarpool.setArrivalTime(carpoolUpdateDTO.getArrivalTime());
//        }
//        if (carpoolUpdateDTO.getBookingStatus() != null) {
//            existingCarpool.setBookingStatus(carpoolUpdateDTO.getBookingStatus());
//        }
//        if (carpoolUpdateDTO.getAvailableSeats() != null) {
//            existingCarpool.setAvailableSeats(carpoolUpdateDTO.getAvailableSeats());
//        }

        existingCarpool = carpoolRepository.save(existingCarpool);

        return convertToResponseDTO(existingCarpool);
    }

    private CarpoolResponseDTO convertToResponseDTO(Carpool carpool) {
        CarpoolResponseDTO responseDTO = new CarpoolResponseDTO();
        responseDTO.setCarpoolId(carpool.getCarpoolId());
        responseDTO.setDriver(carpool.getUser().getUsername());
        responseDTO.setDepartureLocation(carpool.getDepartureLocation());
        responseDTO.setArrivalLocation(carpool.getArrivalLocation());
        responseDTO.setDepartureTime(carpool.getDepartureTime());
        responseDTO.setArrivalTime(carpool.getArrivalTime());
        responseDTO.setAvailableSeats(carpool.getAvailableSeats());
        responseDTO.setCarId(carpool.getCar().getCarId());
        responseDTO.setUserId(carpool.getUser().getUserId());

        return responseDTO;
    }

    public CarpoolResponseDTO getCarpoolById(Long id) {
        Optional<Carpool> carpool = carpoolRepository.findById(id);

        return carpool.map(this::convertToResponseDTO)
                .orElseGet(CarpoolResponseDTO::new);
    }

    public boolean deleteCarpool(Long id) {
        Optional<Carpool> carpool = carpoolRepository.findById(id);

        if (carpool.isPresent()) {
            carpoolRepository.delete(carpool.get());
            return true;
        }

        return false;
    }

}
