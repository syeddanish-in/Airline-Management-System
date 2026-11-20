package com.airline.management.flight.controller;

import java.util.List;
import com.airline.management.flight.model.Flight;
import com.airline.management.flight.service.FlightService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FlightController {

    @GetMapping("/flights")
    public List<Flight> getflights() {
        return flightservice.getAllFlights();
    }

    private final FlightService flightservice;

    public FlightController(FlightService flightservice) {
        this.flightservice = flightservice;
    }
}