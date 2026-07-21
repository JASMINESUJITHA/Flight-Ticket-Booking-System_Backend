package com.flightbooking.controller;

import com.flightbooking.dto.PassengerDTO;
import com.flightbooking.service.PassengerService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;


    @PostMapping
    public ResponseEntity<PassengerDTO> createPassenger(
            @RequestBody PassengerDTO passengerDTO) {

        PassengerDTO savedPassenger =
                passengerService.createPassenger(passengerDTO);

        return new ResponseEntity<>(
                savedPassenger,
                HttpStatus.CREATED
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> getPassengerById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                passengerService.getPassengerById(id)
        );
    }


    @GetMapping
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {

        return ResponseEntity.ok(
                passengerService.getAllPassengers()
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<PassengerDTO> updatePassenger(
            @PathVariable Long id,
            @RequestBody PassengerDTO passengerDTO) {

        return ResponseEntity.ok(
                passengerService.updatePassenger(id, passengerDTO)
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(
            @PathVariable Long id) {

        passengerService.deletePassenger(id);

        return ResponseEntity.ok(
                "Passenger deleted successfully"
        );
    }

}