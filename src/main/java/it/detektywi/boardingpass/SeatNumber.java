package it.detektywi.boardingpass;

class SeatNumber {
    private final int row;
    private final Column column;

    SeatNumber(int row, Column column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return String.format("%03d%s", row, column);
    }

    enum Column {
        A, B, C, D
    }
}
