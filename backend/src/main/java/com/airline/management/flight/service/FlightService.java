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

    public List<Flight> getAllFlights() {
        return flights;
    }

    public Flight addFlight(Flight flight) {
        flights.add(flight);
        return flight;
    }

    public Flight getFlightById(Long id) {
        for (Flight flight : flights) {
            if (flight.getId().equals(id)) {
                return flight;
            }
        }
        return null;
    }

}