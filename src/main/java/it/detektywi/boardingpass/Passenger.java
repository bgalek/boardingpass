package it.detektywi.boardingpass;

class Passenger {

    private final String firstName;
    private final String lastName;

    Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        assert firstName.length() + lastName.length() < 19;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }
}
