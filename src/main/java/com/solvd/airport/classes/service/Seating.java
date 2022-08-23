package com.solvd.airport.classes.service;

import com.solvd.airport.classes.entity.AirPlane;

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

    public static void setSeats(char[][] seats) {
        int firstCol = (int) 'A';
        for (int r = 0; r < seats.length; r++) {
            for (int c = 0; c < seats[r].length; c++) {
                seats[r][c] = (char) (firstCol + c);
            }
        }
    }
}
