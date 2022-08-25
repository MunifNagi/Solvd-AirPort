package com.solvd.airport.classes.service;

import com.solvd.airport.classes.entity.AirPlane;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.stream.IntStream;

public abstract class Seating {

    public static char[][] getSeats(AirPlane airplane) {
        int rows = airplane.getRows();
        int cols = airplane.getCols();
        char[][] seats = new char[rows][cols];
        setSeats(seats);
        return seats;
    }

    public static void printSeats(char[][] seats) {
        System.out.println("Row");
        IntStream.range(0, seats.length)
                .forEach(
                        r -> {
                            System.out.print((r + 1) + "  ");
                            IntStream.range(0, seats[r].length).forEach(c -> System.out.print(seats[r][c] + " "));
                            System.out.println("");
                        }
                );
    }

    public static void writeSeats(char[][] seats, File file) throws IOException {
        appendStringToFile(file, "Row\n");
        IntStream.range(0, seats.length)
                .forEach(
                        r -> {
                            appendStringToFile(file, (r + 1) + "  ");
                            IntStream.range(0, seats[r].length).forEach(c -> appendStringToFile(file, seats[r][c] + " "));
                            appendStringToFile(file, "\n");
                        }
                );
    }

    public static void setSeats(char[][] seats) {
        char firstCol = 'A';
        IntStream.range(0, seats.length)
                .forEach(r -> IntStream.range(0, seats[r].length).
                        forEach(c -> seats[r][c] = (char) (firstCol + c)));
    }

    public static void appendStringToFile(File file, String string) {
        try {
            FileUtils.writeStringToFile(file, string, Charset.defaultCharset(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
