package it.detektywi.boardingpass;

class BoardingPassData {

    private static final String ADDITIONAL_DATA_SIZE_IN_HEX = "00";
    private static final String FORMATTING_PREFIX = "M1";

    private final Flight flight;
    private final Passenger passenger;
    private final Ticket ticket;

    BoardingPassData(Flight flight, Passenger passenger, Ticket ticket) {
        this.flight = flight;
        this.passenger = passenger;
        this.ticket = ticket;
    }

    String generate() {
        return String.join("",
                FORMATTING_PREFIX,
                rightPad(passenger.getLastName() + '/' + passenger.getFirstName(), 20),
                ticket.getType().toString(),
                rightPad(ticket.getTicketNumber(), 7),
                flight.getOrigin().toString(),
                flight.getDestination().toString(),
                rightPad(flight.getFlightOperator().toString(), 3),
                rightPad(flight.getFlightNumber(), 5),
                leftPad(flight.getFlightDate().getDayOfYear(), 3),
                ticket.getTicketClass().toString(),
                ticket.getSeatNumber().toString(),
                rightPad(leftPad(ticket.getBoardingIndex(), 4), 5),
                PassengerStatus.CHECKED_IN.toString(),
                ADDITIONAL_DATA_SIZE_IN_HEX
        );
    }

    private static String rightPad(String str, int size) {
        return String.format("%1$-" + size + "s", str);
    }

    private static String leftPad(int number, int size) {
        return String.format("%0" + size + "d", number);
    }

}
