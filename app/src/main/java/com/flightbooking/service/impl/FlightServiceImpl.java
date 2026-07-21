package com.flightbooking.service.impl;

import com.flightbooking.dto.FlightDTO;
import com.flightbooking.entity.Flight;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.mapper.FlightMapper;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public FlightDTO addFlight(FlightDTO dto) {

        Flight flight = flightMapper.toEntity(dto);

        // Initially all seats are available
        flight.setAvailableSeats(dto.getTotalSeats());

        return flightMapper.toDTO(flightRepository.save(flight));
    }

    @Override
    public FlightDTO updateFlight(Long id, FlightDTO dto) {

        Flight flight = flightRepository.findById(id)
                .orElseThrow(() ->
                        new FlightNotFoundException("Flight Not Found"));

        flight.setFlightNo(dto.getFlightNo());
        flight.setAirlineNo(dto.getAirlineNo());
        flight.setSource(dto.getSource());
        flight.setDestination(dto.getDestination());
        flight.setDepartureTime(dto.getDepartureTime());
        flight.setArrivalTime(dto.getArrivalTime());
        flight.setTotalSeats(dto.getTotalSeats());
        flight.setAvailableSeats(dto.getAvailableSeats());
        flight.setPrice(dto.getPrice());

        return flightMapper.toDTO(
                flightRepository.save(flight)
        );
    }

    @Override
    public void deleteFlight(Long id) {

        Flight flight = flightRepository.findById(id)
                .orElseThrow(() ->
                        new FlightNotFoundException("Flight Not Found"));

        flightRepository.delete(flight);
    }

    @Override
    public FlightDTO getFlightById(Long id) {

        Flight flight = flightRepository.findById(id)
                .orElseThrow(() ->
                        new FlightNotFoundException("Flight Not Found"));

        return flightMapper.toDTO(flight);
    }

    @Override
    public List<FlightDTO> getAllFlights() {

        return flightMapper.toDTO(
                flightRepository.findAll()
        );
    }

    @Override
    public List<FlightDTO> searchFlight(String source,
                                        String destination,
                                        LocalDate travelDate) {

        List<Flight> flights = flightRepository
                .findBySourceIgnoreCaseAndDestinationIgnoreCase(
                        source,
                        destination
                );

        List<Flight> filteredFlights = flights.stream()

                // Match Travel Date
                .filter(flight ->
                        flight.getDepartureTime()
                                .toLocalDate()
                                .equals(travelDate)
                )

                // Show only available flights
                .filter(flight ->
                        flight.getAvailableSeats() > 0
                )

                // Sort by departure time
                .sorted(
                        Comparator.comparing(Flight::getDepartureTime)
                )

                .collect(Collectors.toList());

        return flightMapper.toDTO(filteredFlights);
    }

}