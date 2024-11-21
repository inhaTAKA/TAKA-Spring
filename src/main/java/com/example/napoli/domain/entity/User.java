package com.example.napoli.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CREATED_AT")
    private LocalDate createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carpool> carPools;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings;

}
