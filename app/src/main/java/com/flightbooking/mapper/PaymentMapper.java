package com.flightbooking.mapper;

import com.flightbooking.dto.PaymentDTO;
import com.flightbooking.entity.Booking;
import com.flightbooking.entity.Payment;

import org.springframework.stereotype.Component;


@Component
public class PaymentMapper {


    public PaymentDTO toDTO(Payment payment) {

        if (payment == null) {
            return null;
        }


        return PaymentDTO.builder()
                .id(payment.getId())
                .paymentReference(payment.getPaymentReference())
                .amount(payment.getAmount())
                .paymentStatus(payment.getPaymentStatus())
                .paymentMethod(payment.getPaymentMethod())
                .bookingId(
                        payment.getBooking() != null
                                ? payment.getBooking().getId()
                                : null
                )
                .build();
    }



    public Payment toEntity(
            PaymentDTO paymentDTO,
            Booking booking
    ) {

        if (paymentDTO == null) {
            return null;
        }


        return Payment.builder()
                .id(paymentDTO.getId())
                .paymentReference(paymentDTO.getPaymentReference())
                .amount(paymentDTO.getAmount())
                .paymentStatus(paymentDTO.getPaymentStatus())
                .paymentMethod(paymentDTO.getPaymentMethod())
                .booking(booking)
                .build();

    }

}