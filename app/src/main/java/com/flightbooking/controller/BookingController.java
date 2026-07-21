package com.flightbooking.controller;

import com.flightbooking.dto.BookingDTO;
import com.flightbooking.service.BookingService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;


    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(
            @RequestBody BookingDTO bookingDTO) {

        return new ResponseEntity<>(
                bookingService.createBooking(bookingDTO),
                HttpStatus.CREATED
        );
    }



    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                bookingService.getBookingById(id)
        );
    }



    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {

        return ResponseEntity.ok(
                bookingService.getAllBookings()
        );
    }



    @PutMapping("/{id}")
    public ResponseEntity<BookingDTO> updateBooking(
            @PathVariable Long id,
            @RequestBody BookingDTO bookingDTO) {

        return ResponseEntity.ok(
                bookingService.updateBooking(id, bookingDTO)
        );
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(
            @PathVariable Long id) {

        bookingService.cancelBooking(id);

        return ResponseEntity.ok(
                "Booking cancelled successfully"
        );
    }

}