package com.flightbooking.service;

import com.flightbooking.dto.AuthRequest;
import com.flightbooking.dto.AuthResponse;
import com.flightbooking.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(AuthRequest request);
}