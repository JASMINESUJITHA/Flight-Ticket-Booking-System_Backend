package com.flightbooking.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {


    private Long id;

    private String ticketNumber;

    private String seatNumber;

    private String ticketStatus;

    private Long bookingId;

}