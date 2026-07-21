package com.flightbooking.service;

import com.flightbooking.dto.TicketDTO;

import java.util.List;


public interface TicketService {


    TicketDTO createTicket(TicketDTO ticketDTO);


    TicketDTO getTicketById(Long id);


    List<TicketDTO> getAllTickets();


    TicketDTO updateTicket(Long id, TicketDTO ticketDTO);


    void deleteTicket(Long id);

}