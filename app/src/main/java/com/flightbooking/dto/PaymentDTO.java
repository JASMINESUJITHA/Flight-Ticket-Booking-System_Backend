package com.flightbooking.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {


    private Long id;

    private String paymentReference;

    private Double amount;

    private String paymentStatus;

    private String paymentMethod;

    private Long bookingId;

}