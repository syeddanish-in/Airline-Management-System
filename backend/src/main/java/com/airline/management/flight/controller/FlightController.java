package com.airline.management.flight.controller;

import java.util.List;
import com.airline.management.flight.model.Flight;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FlightController {

    @GetMapping("/flights")
    public List<Flight> getflights() {
        return List.of(
                new Flight(1L, "EK501", "Dubai", "Mumbai", "10:30", 850.0),
                new Flight(2L, "EK502", "Dubai", "Delhi", "14:45", 1200.0));
    }
}
