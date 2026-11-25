package com.airline.management.flight.service;

import com.airline.management.flight.model.Flight;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import java.util.Optional;

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
    public Optional<Flight> getFlightById(Long id) {
        return flights.stream()
                .filter(flight -> flight.getId().equals(id))
                .findFirst();
    }

    // Update Flight
    public Flight updateFlight(Long id, Flight updateFlight) {
        Flight existingFlight = getFlightById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        existingFlight.setFlightNumber(updateFlight.getFlightNumber());
        existingFlight.setOrigin(updateFlight.getOrigin());
        existingFlight.setDestination(updateFlight.getDestination());
        existingFlight.setDepartureTime(updateFlight.getDepartureTime());
        existingFlight.setPrice(updateFlight.getPrice());

        return existingFlight;
    }

    // Delete Flight
    public void deleteFlight(Long id) {
        Flight flight = getFlightById(id).orElseThrow(() -> new RuntimeException("Flight not found"));

        flights.remove(flight);
    }
}