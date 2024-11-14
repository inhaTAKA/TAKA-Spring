package com.example.napoli.domain.dto.Carpool;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class CarpoolDTOBase {
    private Long carpoolId;
    private String driver;
    private String departureLocation;
    private String arrivalLocation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer availableSeats;

}
