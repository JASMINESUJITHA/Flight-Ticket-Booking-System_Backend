package com.flightbooking.service.impl;

import com.flightbooking.dto.TicketDTO;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.Ticket;
import com.flightbooking.exception.ResourceNotFoundException;
import com.flightbooking.mapper.TicketMapper;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.TicketRepository;
import com.flightbooking.service.TicketService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {


    private final TicketRepository ticketRepository;

    private final BookingRepository bookingRepository;

    private final TicketMapper ticketMapper;



    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO) {


        Booking booking =
                bookingRepository.findById(ticketDTO.getBookingId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Booking not found"
                                ));



        ticketDTO.setTicketNumber(
                "TKT-" + UUID.randomUUID()
                        .toString()
                        .substring(0,8)
        );


        ticketDTO.setTicketStatus("CONFIRMED");



        Ticket ticket =
                ticketMapper.toEntity(
                        ticketDTO,
                        booking
                );


        Ticket savedTicket =
                ticketRepository.save(ticket);



        return ticketMapper.toDTO(savedTicket);

    }





    @Override
    public TicketDTO getTicketById(Long id) {


        Ticket ticket =
                ticketRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Ticket not found"
                                ));



        return ticketMapper.toDTO(ticket);

    }





    @Override
    public List<TicketDTO> getAllTickets() {


        return ticketRepository.findAll()
                .stream()
                .map(ticketMapper::toDTO)
                .collect(Collectors.toList());

    }





    @Override
    public TicketDTO updateTicket(
            Long id,
            TicketDTO ticketDTO
    ) {


        Ticket ticket =
                ticketRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Ticket not found"
                                ));



        ticket.setSeatNumber(
                ticketDTO.getSeatNumber()
        );


        ticket.setTicketStatus(
                ticketDTO.getTicketStatus()
        );



        Ticket updatedTicket =
                ticketRepository.save(ticket);



        return ticketMapper.toDTO(updatedTicket);

    }





    @Override
    public void deleteTicket(Long id) {


        Ticket ticket =
                ticketRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Ticket not found"
                                ));



        ticketRepository.delete(ticket);

    }

}