package com.flightbooking.mapper;

import com.flightbooking.dto.PassengerDTO;
import com.flightbooking.entity.Passenger;
import com.flightbooking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {

    public PassengerDTO toDTO(Passenger passenger) {

        if (passenger == null) {
            return null;
        }

        return PassengerDTO.builder()
                .id(passenger.getId())
                .firstName(passenger.getFirstName())
                .lastName(passenger.getLastName())
                .passportNumber(passenger.getPassportNumber())
                .age(passenger.getAge())
                .gender(passenger.getGender())
                .phoneNumber(passenger.getPhoneNumber())
                .userId(
                        passenger.getUser() != null
                                ? passenger.getUser().getId()
                                : null
                )
                .build();
    }


    public Passenger toEntity(PassengerDTO passengerDTO, User user) {

        if (passengerDTO == null) {
            return null;
        }

        return Passenger.builder()
                .id(passengerDTO.getId())
                .firstName(passengerDTO.getFirstName())
                .lastName(passengerDTO.getLastName())
                .passportNumber(passengerDTO.getPassportNumber())
                .age(passengerDTO.getAge())
                .gender(passengerDTO.getGender())
                .phoneNumber(passengerDTO.getPhoneNumber())
                .user(user)
                .build();
    }
}