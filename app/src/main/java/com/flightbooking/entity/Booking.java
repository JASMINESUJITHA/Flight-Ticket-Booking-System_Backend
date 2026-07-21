package com.flightbooking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String bookingReference;


    @Column(nullable = false)
    private LocalDateTime bookingDate;


    @Column(nullable = false)
    private Integer numberOfSeats;


    @Column(nullable = false)
    private String status;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @OneToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;


    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;


    @OneToOne(
            mappedBy = "booking",
            cascade = CascadeType.ALL
    )
    private Payment payment;


    @OneToOne(
            mappedBy = "booking",
            cascade = CascadeType.ALL
    )
    private Ticket ticket;

}