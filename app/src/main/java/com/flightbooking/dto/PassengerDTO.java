package com.flightbooking.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String passportNumber;

    private Integer age;

    private String gender;

    private String phoneNumber;

    private Long userId;

}