package com.solvd.airport.classes.service;

import com.solvd.airport.classes.entity.AirPlane;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

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
        for (int r = 0; r < seats.length; r++) {
            System.out.print((r + 1) + "  ");
            for (int c = 0; c < seats[r].length; c++) {
                System.out.print(seats[r][c] + " ");
            }
            System.out.println("");
        }
    }

    public static void writeSeats(char[][] seats, File file) throws IOException {
        FileUtils.writeStringToFile(file, "Row\n", true);
        for (int r = 0; r < seats.length; r++) {
            FileUtils.writeStringToFile(file, (r + 1) + "  ", true);
            for (int c = 0; c < seats[r].length; c++) {
                FileUtils.writeStringToFile(file, seats[r][c] + " ", true);
            }
            FileUtils.writeStringToFile(file, "\n", true);
        }
    }

    public static void setSeats(char[][] seats) {
        int firstCol = (int) 'A';
        for (int r = 0; r < seats.length; r++) {
            for (int c = 0; c < seats[r].length; c++) {
                seats[r][c] = (char) (firstCol + c);
            }
        }
    }
}
