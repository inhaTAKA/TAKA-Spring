package com.example.napoli.domain.dto.Carpool;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarpoolUpdateDTO extends CarpoolDTOBase {
    private String carId;
    private Long userId;
    private String bookingStatus;

}
