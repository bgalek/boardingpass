package it.detektywi.boardingpass;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardingPassDataTest {

    @Test
    void shouldGenerateValidBoardingData() {
        // given flight
        var flight = new Flight("1234",
                AirportCode.valueOf("ZRH"),
                AirportCode.valueOf("SFO"),
                new FlightOperator("BA"),
                LocalDate.of(2018, 7, 31)
        );

        // and passenger
        var passenger = new Passenger("JOHN", "DOE");

        // and ticket
        var ticket = new Ticket("XYZ123", TicketClass.FIRST, new SeatNumber(35, SeatNumber.Column.A), 1);

        // when generating data
        String data = new BoardingPassData(flight, passenger, ticket).generate();

        // then it should be valid
        assertEquals("M1DOE/JOHN            EXYZ123 ZRHSFOBA 1234 212F035A0001 100", data);
    }
}