package com.airline.management.flight.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FlightController {

    @GetMapping("/flights")
    public String getflight() {
        return "Flight Api is Working!";
    }
}
