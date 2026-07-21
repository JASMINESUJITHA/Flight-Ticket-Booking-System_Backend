package com.flightbooking.service.impl;

import com.flightbooking.dto.PassengerDTO;
import com.flightbooking.entity.Passenger;
import com.flightbooking.entity.User;
import com.flightbooking.exception.ResourceNotFoundException;
import com.flightbooking.mapper.PassengerMapper;
import com.flightbooking.repository.PassengerRepository;
import com.flightbooking.repository.UserRepository;
import com.flightbooking.service.PassengerService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final UserRepository userRepository;
    private final PassengerMapper passengerMapper;


    @Override
    public PassengerDTO createPassenger(PassengerDTO passengerDTO) {

        User user = userRepository.findById(passengerDTO.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id : "
                                + passengerDTO.getUserId()));

        Passenger passenger = passengerMapper.toEntity(passengerDTO, user);

        Passenger savedPassenger = passengerRepository.save(passenger);

        return passengerMapper.toDTO(savedPassenger);
    }


    @Override
    public PassengerDTO getPassengerById(Long id) {

        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Passenger not found with id : " + id));

        return passengerMapper.toDTO(passenger);
    }


    @Override
    public List<PassengerDTO> getAllPassengers() {

        return passengerRepository.findAll()
                .stream()
                .map(passengerMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public PassengerDTO updatePassenger(Long id, PassengerDTO passengerDTO) {

        Passenger existingPassenger = passengerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Passenger not found with id : " + id));


        existingPassenger.setFirstName(passengerDTO.getFirstName());
        existingPassenger.setLastName(passengerDTO.getLastName());
        existingPassenger.setPassportNumber(passengerDTO.getPassportNumber());
        existingPassenger.setAge(passengerDTO.getAge());
        existingPassenger.setGender(passengerDTO.getGender());
        existingPassenger.setPhoneNumber(passengerDTO.getPhoneNumber());


        Passenger updatedPassenger =
                passengerRepository.save(existingPassenger);


        return passengerMapper.toDTO(updatedPassenger);
    }


    @Override
    public void deletePassenger(Long id) {

        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Passenger not found with id : " + id));

        passengerRepository.delete(passenger);
    }

}