package com.example.napoli.domain.dto;

public record RegisterCarDto(
        String firstStartAddress,
        String secondStartAddress,
        String firstTransitAddress1,
        String firstTransitAddress2,
        String firstTransitAddress3,
        String secondTransitAddress1,
        String secondTransitAddress2,
        String secondTransitAddress3,
        int minDesiredCharge,
        int maxDesiredCharge,
        String sex
) {

    @Override
    public String toString() {
        return "RegisterCarDto{" +
                "firstStartAddress='" + firstStartAddress + '\'' +
                ", secondStartAddress='" + secondStartAddress + '\'' +
                ", firstTransitAddress1='" + firstTransitAddress1 + '\'' +
                ", firstTransitAddress2='" + firstTransitAddress2 + '\'' +
                ", firstTransitAddress3='" + firstTransitAddress3 + '\'' +
                ", secondTransitAddress1='" + secondTransitAddress1 + '\'' +
                ", secondTransitAddress2='" + secondTransitAddress2 + '\'' +
                ", secondTransitAddress3='" + secondTransitAddress3 + '\'' +
                ", minDesiredCharge=" + minDesiredCharge +
                ", maxDesiredCharge=" + maxDesiredCharge +
                ", sex='" + sex + '\'' +
                '}';
    }
}
