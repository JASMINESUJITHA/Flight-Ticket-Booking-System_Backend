package com.flightbooking.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDTO {

    private Long id;

    @NotBlank(message = "Flight Number is required")
    private String flightNo;

    @NotBlank(message = "Airline Name is required")
    private String airlineNo;

    @NotBlank(message = "Source is required")
    private String source;

    @NotBlank(message = "Destination is required")
    private String destination;

    @NotNull(message = "Departure Time is required")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival Time is required")
    private LocalDateTime arrivalTime;

    @Min(value = 1, message = "Total Seats should be greater than 0")
    private int totalSeats;

    @Min(value = 0)
    private int availableSeats;

    @Min(value = 1, message = "Price should be greater than 0")
    private double price;

}