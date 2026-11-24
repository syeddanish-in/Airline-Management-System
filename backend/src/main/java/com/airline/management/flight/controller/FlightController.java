package com.airline.management.flight.controller;

import java.util.List;
import com.airline.management.flight.model.Flight;
import com.airline.management.flight.service.FlightService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class FlightController {

    private final FlightService flightservice;

    public FlightController(FlightService flightservice) {
        this.flightservice = flightservice;
    }

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return flightservice.getAllFlights();
    }

    @PostMapping("/flights")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightservice.addFlight(flight);
    }

}