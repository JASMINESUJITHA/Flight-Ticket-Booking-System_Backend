package com.flightbooking.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {

    private Long id;

    private String bookingReference;

    private LocalDateTime bookingDate;

    private Integer numberOfSeats;

    private String status;

    private Long userId;

    private Long passengerId;

    private Long flightId;

}