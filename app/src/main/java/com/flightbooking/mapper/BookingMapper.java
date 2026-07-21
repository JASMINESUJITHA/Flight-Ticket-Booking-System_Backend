package com.flightbooking.mapper;

import com.flightbooking.dto.BookingDTO;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.Passenger;
import com.flightbooking.entity.User;

import org.springframework.stereotype.Component;

@Component
public class BookingMapper {


    public BookingDTO toDTO(Booking booking) {

        if (booking == null) {
            return null;
        }

        return BookingDTO.builder()
                .id(booking.getId())
                .bookingReference(booking.getBookingReference())
                .bookingDate(booking.getBookingDate())
                .numberOfSeats(booking.getNumberOfSeats())
                .status(booking.getStatus())
                .userId(
                        booking.getUser() != null
                                ? booking.getUser().getId()
                                : null
                )
                .passengerId(
                        booking.getPassenger() != null
                                ? booking.getPassenger().getId()
                                : null
                )
                .flightId(
                        booking.getFlight() != null
                                ? booking.getFlight().getId()
                                : null
                )
                .build();
    }


    public Booking toEntity(
            BookingDTO bookingDTO,
            User user,
            Passenger passenger,
            Flight flight
    ) {

        if (bookingDTO == null) {
            return null;
        }


        return Booking.builder()
                .id(bookingDTO.getId())
                .bookingReference(bookingDTO.getBookingReference())
                .bookingDate(bookingDTO.getBookingDate())
                .numberOfSeats(bookingDTO.getNumberOfSeats())
                .status(bookingDTO.getStatus())
                .user(user)
                .passenger(passenger)
                .flight(flight)
                .build();
    }

}