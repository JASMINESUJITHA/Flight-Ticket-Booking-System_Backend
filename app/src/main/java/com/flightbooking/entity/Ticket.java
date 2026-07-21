package com.flightbooking.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String ticketNumber;


    @Column(nullable = false)
    private String seatNumber;


    @Column(nullable = false)
    private String ticketStatus;



    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

}