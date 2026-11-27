package com.airline.management.flight.service;

import com.airline.management.flight.model.Flight;
import com.airline.management.flight.repository.FlightRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    // Constructor injection
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Get all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Add flight
    public Flight addFlight(Flight flight) {
        flight.setId(null);
        return flightRepository.save(flight);
    }

    // Get flight by ID
    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    // Update flight
    public Flight updateFlight(Long id, Flight updatedFlight) {

        Flight existingFlight = flightRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Flight not found with ID: " + id));

        existingFlight.setFlightNumber(updatedFlight.getFlightNumber());
        existingFlight.setOrigin(updatedFlight.getOrigin());
        existingFlight.setDestination(updatedFlight.getDestination());
        existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
        existingFlight.setPrice(updatedFlight.getPrice());

        return flightRepository.save(existingFlight);
    }

    // Delete flight
    public void deleteFlight(Long id) {

        Flight existingFlight = flightRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Flight not found with ID: " + id));

        flightRepository.delete(existingFlight);
    }
}