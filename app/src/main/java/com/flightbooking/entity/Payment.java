package com.flightbooking.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String paymentReference;


    @Column(nullable = false)
    private Double amount;


    @Column(nullable = false)
    private String paymentStatus;


    @Column(nullable = false)
    private String paymentMethod;



    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

}