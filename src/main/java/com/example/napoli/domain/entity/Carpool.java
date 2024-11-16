package com.example.napoli.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Carpool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARPOOL_ID")
    private Long carpoolId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

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
    private int restSeat;
    private String sex;
}
