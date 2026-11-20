package com.airline.management.flight.service;

import com.airline.management.flight.model.Flight;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    public List<Flight> getAllFlights() {
        return List.of(
                new Flight(1L, "EK501", "Dubai", "Mumbai", "10:30", 850.0),
                new Flight(2L, "EK502", "Dubai", "Delhi", "14:45", 1200.0));
    }
}
