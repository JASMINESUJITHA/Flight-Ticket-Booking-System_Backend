package com.flightbooking.mapper;

import com.flightbooking.dto.PassengerDTO;
import com.flightbooking.entity.Passenger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T09:33:56+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class PassengerMapperImpl implements PassengerMapper {

    @Override
    public Passenger toEntity(PassengerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Passenger.PassengerBuilder passenger = Passenger.builder();

        passenger.id( dto.getId() );
        passenger.firstName( dto.getFirstName() );
        passenger.lastName( dto.getLastName() );
        passenger.gender( dto.getGender() );
        passenger.age( dto.getAge() );
        passenger.email( dto.getEmail() );
        passenger.mobileNo( dto.getMobileNo() );

        return passenger.build();
    }

    @Override
    public PassengerDTO toDTO(Passenger entity) {
        if ( entity == null ) {
            return null;
        }

        PassengerDTO.PassengerDTOBuilder passengerDTO = PassengerDTO.builder();

        passengerDTO.id( entity.getId() );
        passengerDTO.firstName( entity.getFirstName() );
        passengerDTO.lastName( entity.getLastName() );
        passengerDTO.gender( entity.getGender() );
        passengerDTO.age( entity.getAge() );
        passengerDTO.email( entity.getEmail() );
        passengerDTO.mobileNo( entity.getMobileNo() );

        return passengerDTO.build();
    }

    @Override
    public List<PassengerDTO> toDTO(List<Passenger> list) {
        if ( list == null ) {
            return null;
        }

        List<PassengerDTO> list1 = new ArrayList<PassengerDTO>( list.size() );
        for ( Passenger passenger : list ) {
            list1.add( toDTO( passenger ) );
        }

        return list1;
    }
}
