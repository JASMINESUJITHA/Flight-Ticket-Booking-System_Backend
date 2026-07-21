package com.flightbooking.mapper;

import com.flightbooking.dto.FlightDTO;
import com.flightbooking.entity.Flight;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    Flight toEntity(FlightDTO dto);

    FlightDTO toDTO(Flight entity);

    List<FlightDTO> toDTO(List<Flight> list);

}