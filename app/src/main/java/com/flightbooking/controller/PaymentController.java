package com.flightbooking.controller;

import com.flightbooking.dto.PaymentDTO;
import com.flightbooking.service.PaymentService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {


    private final PaymentService paymentService;



    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(
            @RequestBody PaymentDTO paymentDTO) {


        return new ResponseEntity<>(
                paymentService.createPayment(paymentDTO),
                HttpStatus.CREATED
        );

    }




    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(
            @PathVariable Long id) {


        return ResponseEntity.ok(
                paymentService.getPaymentById(id)
        );

    }




    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {


        return ResponseEntity.ok(
                paymentService.getAllPayments()
        );

    }





    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(
            @PathVariable Long id,
            @RequestBody PaymentDTO paymentDTO) {


        return ResponseEntity.ok(
                paymentService.updatePayment(id, paymentDTO)
        );

    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(
            @PathVariable Long id) {


        paymentService.deletePayment(id);


        return ResponseEntity.ok(
                "Payment deleted successfully"
        );

    }

}