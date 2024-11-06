package com.example.napoli.controller;

import com.example.napoli.domain.dto.Carpool.CarpoolResponseDTO;
import com.example.napoli.domain.dto.Carpool.CarpoolUpdateDTO;
import com.example.napoli.domain.dto.RegisterCarDto;
import com.example.napoli.service.Carpool.CarpoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carpools")
public class CarpoolController {

    private final CarpoolService carpoolService;

    @Autowired
    public CarpoolController(CarpoolService carpoolService) {
        this.carpoolService = carpoolService;
    }

    @PostMapping
    public ResponseEntity<CarpoolResponseDTO> createCarpool(@RequestBody CarpoolUpdateDTO carpoolDTO) {
        CarpoolResponseDTO createdCarpool = carpoolService.createCarpool(carpoolDTO);
        return new ResponseEntity<>(createdCarpool, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarpoolResponseDTO>> getAllCarpools() {
        List<CarpoolResponseDTO> carpools = carpoolService.getAllCarpools();
        return new ResponseEntity<>(carpools, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarpoolResponseDTO> getCarpoolById(@PathVariable Long id) {
        CarpoolResponseDTO carpool = carpoolService.getCarpoolById(id);
        if (carpool != null) {
            return new ResponseEntity<>(carpool, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarpoolResponseDTO> updateCarpool(@PathVariable Long id, @RequestBody CarpoolUpdateDTO carpoolDTO) {
        CarpoolResponseDTO updatedCarpool = carpoolService.updateCarpool(id, carpoolDTO);
        if (updatedCarpool != null) {
            return new ResponseEntity<>(updatedCarpool, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarpool(@PathVariable Long id) {
        // 카풀 삭제 서비스 호출
        boolean isDeleted = carpoolService.deleteCarpool(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registerCar")
    public ResponseEntity<String> registerCar(@RequestBody RegisterCarDto registerCarDto) {
        System.out.println(registerCarDto.toString());
        return new ResponseEntity<>("redirect:/carList", HttpStatus.CREATED);
    }
}
