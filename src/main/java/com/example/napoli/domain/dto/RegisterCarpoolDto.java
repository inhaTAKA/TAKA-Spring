package com.example.napoli.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterCarpoolDto {
    String firstStartAddress;
    String secondStartAddress;
    String detailedAddress;
    String firstTransitAddress1;
    String firstTransitAddress2;
    String firstTransitAddress3;
    String secondTransitAddress1;
    String secondTransitAddress2;
    String secondTransitAddress3;
    int minDesiredCharge;
    int maxDesiredCharge;
    String sex;
}