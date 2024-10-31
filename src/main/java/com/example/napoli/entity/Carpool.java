package com.example.napoli.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Carpool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departureLocation;
    private String destination;
    private LocalDateTime departureTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User driver;

    // Getters and Setters
}
