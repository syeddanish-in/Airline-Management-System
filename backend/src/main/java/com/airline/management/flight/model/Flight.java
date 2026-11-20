package com.airline.management.flight.model;

public class Flight {
    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private double price;

    // constructor
    public Flight(Long id, String flightNumber, String origin, String destination, String departureTime, double price) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public double getPrice() {
        return price;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
