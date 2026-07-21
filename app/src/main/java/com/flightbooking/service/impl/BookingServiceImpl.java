package com.flightbooking.service.impl;

import com.flightbooking.dto.BookingDTO;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.Passenger;
import com.flightbooking.entity.User;
import com.flightbooking.exception.ResourceNotFoundException;
import com.flightbooking.mapper.BookingMapper;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.PassengerRepository;
import com.flightbooking.repository.UserRepository;
import com.flightbooking.service.BookingService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {


    private final BookingRepository bookingRepository;

    private final UserRepository userRepository;

    private final PassengerRepository passengerRepository;

    private final FlightRepository flightRepository;

    private final BookingMapper bookingMapper;



    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {


        User user = userRepository.findById(bookingDTO.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));


        Passenger passenger = passengerRepository.findById(
                        bookingDTO.getPassengerId()
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException("Passenger not found"));


        Flight flight = flightRepository.findById(
                        bookingDTO.getFlightId()
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException("Flight not found"));


        if (flight.getAvailableSeats() < bookingDTO.getNumberOfSeats()) {

            throw new RuntimeException("Not enough seats available");
        }


        flight.setAvailableSeats(
                flight.getAvailableSeats()
                        - bookingDTO.getNumberOfSeats()
        );


        flightRepository.save(flight);



        bookingDTO.setBookingReference(
                "BK-" + UUID.randomUUID()
                        .toString()
                        .substring(0,8)
        );


        bookingDTO.setBookingDate(LocalDateTime.now());

        bookingDTO.setStatus("CONFIRMED");



        Booking booking = bookingMapper.toEntity(
                bookingDTO,
                user,
                passenger,
                flight
        );


        Booking savedBooking =
                bookingRepository.save(booking);


        return bookingMapper.toDTO(savedBooking);
    }




    @Override
    public BookingDTO getBookingById(Long id) {

        Booking booking =
                bookingRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Booking not found"
                                ));

        return bookingMapper.toDTO(booking);
    }




    @Override
    public List<BookingDTO> getAllBookings() {

        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }




    @Override
    public BookingDTO updateBooking(
            Long id,
            BookingDTO bookingDTO
    ) {


        Booking booking =
                bookingRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Booking not found"
                                ));



        booking.setStatus(
                bookingDTO.getStatus()
        );


        Booking updated =
                bookingRepository.save(booking);


        return bookingMapper.toDTO(updated);

    }




    @Override
    public void cancelBooking(Long id) {


        Booking booking =
                bookingRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Booking not found"
                                ));


        booking.setStatus("CANCELLED");


        bookingRepository.save(booking);

    }

}