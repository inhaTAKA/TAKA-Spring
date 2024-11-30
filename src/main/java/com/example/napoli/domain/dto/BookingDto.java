package com.example.napoli.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private String userName;
    private String phoneNumber;
    private String pickupLocation;
    private String message;
}
