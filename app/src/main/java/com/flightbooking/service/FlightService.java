package com.flightbooking.service;

import com.flightbooking.dto.FlightDTO;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {

    // Add Flight
    FlightDTO addFlight(FlightDTO dto);

    // Update Flight
    FlightDTO updateFlight(Long id, FlightDTO dto);

    // Delete Flight
    void deleteFlight(Long id);

    // Get Flight by ID
    FlightDTO getFlightById(Long id);

    // Get All Flights
    List<FlightDTO> getAllFlights();

    // Search Flights
    List<FlightDTO> searchFlight(
            String source,
            String destination,
            LocalDate travelDate
    );

}