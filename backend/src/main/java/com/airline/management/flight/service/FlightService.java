package com.airline.management.flight.service;

import com.airline.management.flight.model.Flight;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final List<Flight> flights = new ArrayList<>(List.of(
            new Flight(1L, "EK501", "Dubai", "Mumbai", "10:30", 850.0),
            new Flight(2L, "EK502", "Dubai", "Delhi", "14:45", 1200.0)));

    // Return All Flight
    public List<Flight> getAllFlights() {
        return flights;
    }

    // Add Flight
    public Flight addFlight(Flight flight) {
        flights.add(flight);
        return flight;
    }

    // Get Details by ID
    public Flight getFlightById(Long id) {
        return flights.stream()
                .filter(flight -> flight.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}