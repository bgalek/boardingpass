package it.detektywi.boardingpass;

enum TicketClass {
    ECONOMY("Y"), FIRST("F"), BUSINESS("B");

    private final String code;

    TicketClass(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
