package com.flightbooking.service.impl;

import com.flightbooking.dto.PaymentDTO;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.Payment;
import com.flightbooking.exception.ResourceNotFoundException;
import com.flightbooking.mapper.PaymentMapper;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.PaymentRepository;
import com.flightbooking.service.PaymentService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {


    private final PaymentRepository paymentRepository;

    private final BookingRepository bookingRepository;

    private final PaymentMapper paymentMapper;



    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {


        Booking booking =
                bookingRepository.findById(paymentDTO.getBookingId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Booking not found"
                                ));



        paymentDTO.setPaymentReference(
                "PAY-" + UUID.randomUUID()
                        .toString()
                        .substring(0,8)
        );


        paymentDTO.setPaymentStatus("SUCCESS");



        Payment payment =
                paymentMapper.toEntity(
                        paymentDTO,
                        booking
                );


        Payment savedPayment =
                paymentRepository.save(payment);



        return paymentMapper.toDTO(savedPayment);

    }





    @Override
    public PaymentDTO getPaymentById(Long id) {


        Payment payment =
                paymentRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Payment not found"
                                ));


        return paymentMapper.toDTO(payment);

    }





    @Override
    public List<PaymentDTO> getAllPayments() {


        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toDTO)
                .collect(Collectors.toList());

    }





    @Override
    public PaymentDTO updatePayment(
            Long id,
            PaymentDTO paymentDTO
    ) {


        Payment payment =
                paymentRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Payment not found"
                                ));



        payment.setPaymentStatus(
                paymentDTO.getPaymentStatus()
        );


        payment.setPaymentMethod(
                paymentDTO.getPaymentMethod()
        );


        Payment updatedPayment =
                paymentRepository.save(payment);



        return paymentMapper.toDTO(updatedPayment);

    }





    @Override
    public void deletePayment(Long id) {


        Payment payment =
                paymentRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Payment not found"
                                ));


        paymentRepository.delete(payment);

    }

}