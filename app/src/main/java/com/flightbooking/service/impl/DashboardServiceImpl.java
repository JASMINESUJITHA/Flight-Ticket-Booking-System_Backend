package com.flightbooking.service.impl;

import com.flightbooking.dto.DashboardDTO;
import com.flightbooking.service.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Override
    public DashboardDTO getDashboard() {

        return DashboardDTO.builder()
                .totalFlights(0)
                .totalPassengers(0)
                .totalBookings(0)
                .totalPayments(0)
                .totalRevenue(0.0)
                .build();
    }
}