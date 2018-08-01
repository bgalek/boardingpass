package it.detektywi.boardingpass;

class Ticket {
    private final String ticketNumber;
    private final TicketClass ticketClass;
    private final SeatNumber seatNumber;
    private final int boardingIndex;

    Ticket(String ticketNumber, TicketClass ticketClass, SeatNumber seatNumber, int boardingIndex) {
        this.ticketNumber = ticketNumber;
        this.ticketClass = ticketClass;
        this.seatNumber = seatNumber;
        this.boardingIndex = boardingIndex;
    }

    String getTicketNumber() {
        return ticketNumber;
    }

    TicketClass getTicketClass() {
        return ticketClass;
    }

    SeatNumber getSeatNumber() {
        return seatNumber;
    }

    int getBoardingIndex() {
        return boardingIndex;
    }

    TicketType getType() {
        return TicketType.ELECTRONIC;
    }

    enum TicketType {
        ELECTRONIC("E");

        private final String code;

        TicketType(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }
}

