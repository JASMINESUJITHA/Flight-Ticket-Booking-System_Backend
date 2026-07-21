package com.flightbooking.controller;

import com.flightbooking.dto.TicketDTO;
import com.flightbooking.service.TicketService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {


    private final TicketService ticketService;




    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(
            @RequestBody TicketDTO ticketDTO) {


        return new ResponseEntity<>(
                ticketService.createTicket(ticketDTO),
                HttpStatus.CREATED
        );

    }





    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketById(
            @PathVariable Long id) {


        return ResponseEntity.ok(
                ticketService.getTicketById(id)
        );

    }





    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets() {


        return ResponseEntity.ok(
                ticketService.getAllTickets()
        );

    }





    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(
            @PathVariable Long id,
            @RequestBody TicketDTO ticketDTO) {


        return ResponseEntity.ok(
                ticketService.updateTicket(id, ticketDTO)
        );

    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(
            @PathVariable Long id) {


        ticketService.deleteTicket(id);


        return ResponseEntity.ok(
                "Ticket deleted successfully"
        );

    }

}