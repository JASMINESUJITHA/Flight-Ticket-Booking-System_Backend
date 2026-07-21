package com.flightbooking.mapper;

import com.flightbooking.dto.BookingDTO;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.Passenger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T09:33:55+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingDTO toDTO(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingDTO.BookingDTOBuilder bookingDTO = BookingDTO.builder();

        bookingDTO.passengerId( bookingPassengerId( booking ) );
        bookingDTO.flightId( bookingFlightId( booking ) );
        bookingDTO.id( booking.getId() );
        bookingDTO.bookingDate( booking.getBookingDate() );
        bookingDTO.seatNo( booking.getSeatNo() );
        bookingDTO.ticketPrice( booking.getTicketPrice() );
        bookingDTO.bookingStatus( booking.getBookingStatus() );

        return bookingDTO.build();
    }

    @Override
    public List<BookingDTO> toDTO(List<Booking> bookings) {
        if ( bookings == null ) {
            return null;
        }

        List<BookingDTO> list = new ArrayList<BookingDTO>( bookings.size() );
        for ( Booking booking : bookings ) {
            list.add( toDTO( booking ) );
        }

        return list;
    }

    private Long bookingPassengerId(Booking booking) {
        if ( booking == null ) {
            return null;
        }
        Passenger passenger = booking.getPassenger();
        if ( passenger == null ) {
            return null;
        }
        Long id = passenger.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long bookingFlightId(Booking booking) {
        if ( booking == null ) {
            return null;
        }
        Flight flight = booking.getFlight();
        if ( flight == null ) {
            return null;
        }
        Long id = flight.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
