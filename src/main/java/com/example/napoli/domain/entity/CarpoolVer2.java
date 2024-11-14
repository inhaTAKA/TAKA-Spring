package com.example.napoli.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class CarpoolVer2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARPOOL_ID")
    private Long carpoolId;
    private String firstStartAddress;
    private String secondStartAddress;
    private String detailedAddress;
    private String firstTransitAddress1;
    private String firstTransitAddress2;
    private String firstTransitAddress3;
    private String secondTransitAddress1;
    private String secondTransitAddress2;
    private String secondTransitAddress3;
    private int minDesiredCharge;
    private int maxDesiredCharge;
    private String sex;
}
