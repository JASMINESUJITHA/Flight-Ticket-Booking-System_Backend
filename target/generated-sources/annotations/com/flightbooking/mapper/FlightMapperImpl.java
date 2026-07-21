package com.flightbooking.mapper;

import com.flightbooking.dto.FlightDTO;
import com.flightbooking.entity.Flight;
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
public class FlightMapperImpl implements FlightMapper {

    @Override
    public Flight toEntity(FlightDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Flight.FlightBuilder flight = Flight.builder();

        flight.id( dto.getId() );
        flight.flightNo( dto.getFlightNo() );
        flight.airlineNo( dto.getAirlineNo() );
        flight.source( dto.getSource() );
        flight.destination( dto.getDestination() );
        flight.departureTime( dto.getDepartureTime() );
        flight.arrivalTime( dto.getArrivalTime() );
        flight.totalSeats( dto.getTotalSeats() );
        flight.availableSeats( dto.getAvailableSeats() );
        flight.price( dto.getPrice() );

        return flight.build();
    }

    @Override
    public FlightDTO toDTO(Flight entity) {
        if ( entity == null ) {
            return null;
        }

        FlightDTO.FlightDTOBuilder flightDTO = FlightDTO.builder();

        flightDTO.id( entity.getId() );
        flightDTO.flightNo( entity.getFlightNo() );
        flightDTO.airlineNo( entity.getAirlineNo() );
        flightDTO.source( entity.getSource() );
        flightDTO.destination( entity.getDestination() );
        flightDTO.departureTime( entity.getDepartureTime() );
        flightDTO.arrivalTime( entity.getArrivalTime() );
        flightDTO.totalSeats( entity.getTotalSeats() );
        flightDTO.availableSeats( entity.getAvailableSeats() );
        flightDTO.price( entity.getPrice() );

        return flightDTO.build();
    }

    @Override
    public List<FlightDTO> toDTO(List<Flight> list) {
        if ( list == null ) {
            return null;
        }

        List<FlightDTO> list1 = new ArrayList<FlightDTO>( list.size() );
        for ( Flight flight : list ) {
            list1.add( toDTO( flight ) );
        }

        return list1;
    }
}
