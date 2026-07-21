package com.flightbooking.service;

import com.flightbooking.dto.PassengerDTO;

import java.util.List;

public interface PassengerService {

    PassengerDTO createPassenger(PassengerDTO passengerDTO);

    PassengerDTO getPassengerById(Long id);

    List<PassengerDTO> getAllPassengers();

    PassengerDTO updatePassenger(Long id, PassengerDTO passengerDTO);

    void deletePassenger(Long id);

}