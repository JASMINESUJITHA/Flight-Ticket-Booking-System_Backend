package com.flightbooking.controller;

import com.flightbooking.dto.AuthRequest;
import com.flightbooking.dto.AuthResponse;
import com.flightbooking.dto.RegisterRequest;
import com.flightbooking.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {


    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public AuthResponse register(
            @RequestBody RegisterRequest request){

        return authService.register(request);
    }



    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody AuthRequest request){

        return authService.login(request);
    }

}