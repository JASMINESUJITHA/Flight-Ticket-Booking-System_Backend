package com.flightbooking.controller;

import com.flightbooking.dto.DashboardDTO;
import com.flightbooking.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;


    @GetMapping
    public DashboardDTO getDashboard(){

        return dashboardService.getDashboard();
    }
}