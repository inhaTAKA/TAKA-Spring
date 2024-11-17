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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue
    @Column(name = "BOOKING_ID")
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CARPOOOL_ID")
    private Carpool carpool;

    @Column(name = "BOOKING_TIME")
    private LocalDate bookingTime;

    @Column(name = "APPROVAL_STATUS")
    private Boolean approvalStatus;

    @Column(name = "CONFIRMATION_TIME")
    private Date confirmationTime;

}
