package com.example.napoli.domain.dto.Carpool;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarpoolResponseDTO extends CarpoolDTOBase {
    private String carId;
    private Long userId;
}
