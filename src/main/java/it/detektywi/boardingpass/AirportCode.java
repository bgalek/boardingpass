package it.detektywi.boardingpass;

import com.google.common.base.Preconditions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AirportCode {

    private static final String AIRPORT_CODES_FILENAME = "airport-codes.txt";

    private final static Set<String> codes = loadCodes();
    private final String code;

    private AirportCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }

    static AirportCode valueOf(String code) {
        Preconditions.checkArgument(codes.contains(code));
        return new AirportCode(code);
    }

    private static Set<String> loadCodes() {
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(AIRPORT_CODES_FILENAME).toURI()))) {
            return stream.collect(Collectors.toSet());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptySet();
        }
    }
}
