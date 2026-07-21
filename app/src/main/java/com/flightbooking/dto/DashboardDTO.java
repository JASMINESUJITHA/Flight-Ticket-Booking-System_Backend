package com.flightbooking.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardDTO {

    private long totalFlights;

    private long totalPassengers;

    private long totalBookings;

    private long totalPayments;

    private double totalRevenue;

}