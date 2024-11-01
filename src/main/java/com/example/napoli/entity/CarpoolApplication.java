package com.example.napoli.entity;

import jakarta.persistence.*;

@Entity
public class CarpoolApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carpool_id")
    private Carpool carpool;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User applicant;

    // Getters and Setters
}
