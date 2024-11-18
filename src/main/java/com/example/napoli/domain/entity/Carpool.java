package com.example.napoli.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "carpools")
public class Carpool {
    @Id
    @GeneratedValue
    @Column(name = "CARPOOL_ID")
    private Long carpoolId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "carpool", cascade = CascadeType.ALL)
    private List<Booking> booking;

    private String startLocation;
    private String endLocation;
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
