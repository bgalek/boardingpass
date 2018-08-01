package it.detektywi.boardingpass;

import com.google.common.base.Preconditions;

class FlightOperator {

    private final String code;

    FlightOperator(String code) {
        Preconditions.checkNotNull(code);
        Preconditions.checkArgument(code.length() == 2);
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
