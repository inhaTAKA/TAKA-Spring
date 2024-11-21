package com.example.napoli.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterCarpoolDto {
    String firstStartAddress;
    String secondStartAddress;
    String detailedStartAddress;
    String firstTransitAddress1;
    String firstTransitAddress2;
    String firstTransitAddress3;
    String secondTransitAddress1;
    String secondTransitAddress2;
    String secondTransitAddress3;
    String firstArriveAddress;
    String secondArriveAddress;
    String detailedArriveAddress;
    int minDesiredCharge;
    int maxDesiredCharge;
    Integer restSeat;
    String sex;
}