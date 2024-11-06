package com.example.napoli.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_ID")
    private Long bookingId;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "CARPOOOL_ID")
    private Carpool carpool;

    @Column(name = "BOOKING_TIME")
    private LocalDate bookingTime;

    @Column(name = "APPROVAL_STATUS")
    private Boolean approvalStatus;

    @Column(name = "CONFIRMATION_TIME")
    private Date confirmationTime;

}
