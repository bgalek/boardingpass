package it.detektywi.boardingpass;

enum PassengerStatus {
    NOT_CHECKED_IN,
    CHECKED_IN,
    BAG_CHECKED_PASSENGER_NOT_CHECKED_IN,
    BAG_CHECKED_PASSENGER_CHECKED_IN,
    PASSENGER_PASSED_SECURITY_CHECK,
    PASSENGER_PASSED_SECURITY_GATE_EXIT,
    TRANSIT,
    STANDBY,
    BOARDING_DATA_REVALIDATION_DONE,
    ORIGINAL_BOARDING_LINE_USED_AT_TIME_OF_TICKET_ISSUANCE;

    @Override
    public String toString() {
        return String.valueOf(this.ordinal());
    }
}