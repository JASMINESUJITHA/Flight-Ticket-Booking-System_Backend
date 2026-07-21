package com.flightbooking.mapper;

import com.flightbooking.dto.TicketDTO;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.Ticket;

import org.springframework.stereotype.Component;


@Component
public class TicketMapper {


    public TicketDTO toDTO(Ticket ticket) {


        if(ticket == null){
            return null;
        }


        return TicketDTO.builder()
                .id(ticket.getId())
                .ticketNumber(ticket.getTicketNumber())
                .seatNumber(ticket.getSeatNumber())
                .ticketStatus(ticket.getTicketStatus())
                .bookingId(
                        ticket.getBooking() != null
                                ? ticket.getBooking().getId()
                                : null
                )
                .build();

    }





    public Ticket toEntity(
            TicketDTO ticketDTO,
            Booking booking
    ) {


        if(ticketDTO == null){
            return null;
        }



        return Ticket.builder()
                .id(ticketDTO.getId())
                .ticketNumber(ticketDTO.getTicketNumber())
                .seatNumber(ticketDTO.getSeatNumber())
                .ticketStatus(ticketDTO.getTicketStatus())
                .booking(booking)
                .build();

    }

}