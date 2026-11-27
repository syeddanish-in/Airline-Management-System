
package com.airline.management.flight.service;

import com.airline.management.flight.model.Passenger;
import com.airline.management.flight.repository.PassengerRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger addPassenger(Passenger passenger) {

        if (passengerRepository.existsByEmail(passenger.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email is already registered");
        }

        passenger.setId(null);

        return passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Passenger not found with ID: " + id));
    }

    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {

        Passenger existingPassenger = getPassengerById(id);

        if (!existingPassenger.getEmail().equals(updatedPassenger.getEmail())
                && passengerRepository.existsByEmail(updatedPassenger.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email is already registered");
        }

        existingPassenger.setFirstName(updatedPassenger.getFirstName());
        existingPassenger.setLastName(updatedPassenger.getLastName());
        existingPassenger.setEmail(updatedPassenger.getEmail());
        existingPassenger.setPhone(updatedPassenger.getPhone());

        return passengerRepository.save(existingPassenger);
    }

    public void deletePassenger(Long id) {
        Passenger passenger = getPassengerById(id);
        passengerRepository.delete(passenger);
    }
}
