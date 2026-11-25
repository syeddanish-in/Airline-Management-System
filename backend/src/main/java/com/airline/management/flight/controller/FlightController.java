package com.airline.management.flight.controller;

import java.util.List;
import com.airline.management.flight.model.Flight;
import com.airline.management.flight.service.FlightService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/flights/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Flight not found with id:" + id));
    }

    @PostMapping("/flights")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @PutMapping("/flights/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

}