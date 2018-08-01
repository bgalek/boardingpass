package it.detektywi.boardingpass;

import java.time.LocalDate;

class Flight {

    private final String flightNumber;
    private final AirportCode origin;
    private final AirportCode destination;
    private final FlightOperator flightOperator;
    private final LocalDate flightDate;

    Flight(String flightNumber, AirportCode origin, AirportCode destination,
           FlightOperator flightOperator, LocalDate flightDate) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightOperator = flightOperator;
        this.flightDate = flightDate;
    }

    String getFlightNumber() {
        return flightNumber;
    }

    AirportCode getOrigin() {
        return origin;
    }

    AirportCode getDestination() {
        return destination;
    }

    LocalDate getFlightDate() {
        return flightDate;
    }

    FlightOperator getFlightOperator() {
        return flightOperator;
    }
}
