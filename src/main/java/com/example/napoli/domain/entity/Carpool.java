package com.example.napoli.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Carpools")
public class Carpool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARPOOL_ID")
    private Long carpoolId;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @Column(name = "DEPARTURE_LOCATION")
    private String departureLocation;

    @Column(name = "ARRIVAL_LOCATION")
    private String arrivalLocation;

    @Column(name = "DEPARTURE_TIME")
    private LocalDateTime departureTime;

    @Column(name = "ARRIVAL_TIME")
    private LocalDateTime arrivalTime;

    @Column(name = "BOOKING_STATUS")
    private String bookingStatus;

    @Column(name = "AVAILABLE_SEATS")
    private Integer availableSeats;

}
