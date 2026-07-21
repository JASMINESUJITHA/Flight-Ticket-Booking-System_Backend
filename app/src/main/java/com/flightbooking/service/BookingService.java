package com.flightbooking.service;

import com.flightbooking.dto.BookingDTO;

import java.util.List;

public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO getBookingById(Long id);

    List<BookingDTO> getAllBookings();

    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);

    void cancelBooking(Long id);

}