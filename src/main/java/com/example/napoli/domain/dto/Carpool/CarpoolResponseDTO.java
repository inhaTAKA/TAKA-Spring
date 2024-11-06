package com.example.napoli.domain.dto.Carpool;

public class CarpoolResponseDTO extends CarpoolDTOBase {

    private String carId;
    private Long userId;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
