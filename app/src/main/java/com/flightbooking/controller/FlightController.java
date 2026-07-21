package com.flightbooking.controller;

import com.flightbooking.dto.FlightDTO;
import com.flightbooking.service.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    // Add Flight
    @PostMapping
    public FlightDTO addFlight(@Valid @RequestBody FlightDTO dto) {
        return flightService.addFlight(dto);
    }

    // Update Flight
    @PutMapping("/{id}")
    public FlightDTO updateFlight(@PathVariable Long id,
                                  @Valid @RequestBody FlightDTO dto) {

        return flightService.updateFlight(id, dto);
    }

    // Delete Flight
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id) {

        flightService.deleteFlight(id);
        return "Flight Deleted Successfully";
    }

    // Get Flight By Id
    @GetMapping("/{id}")
    public FlightDTO getFlight(@PathVariable Long id) {

        return flightService.getFlightById(id);
    }

    // Get All Flights
    @GetMapping
    public List<FlightDTO> getAllFlights() {

        return flightService.getAllFlights();
    }

    // Search Flights
    @GetMapping("/search")
    public List<FlightDTO> searchFlight(

            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam LocalDate travelDate

    ) {

        return flightService.searchFlight(
                source,
                destination,
                travelDate
        );
    }

}