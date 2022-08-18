package com.solvd.airport.classes.entity;

import com.solvd.airport.interfaces.BookSeat;

public class AirPlane implements BookSeat {
    private String name;
    private String modelNumber;
    private int maxSeats;
    private int rows;
    private int bookedSeats;
    private char[][] seats;

    public AirPlane(String planeName, String model, int rows) {
        this.name = planeName;
        this.modelNumber = model;
        this.rows = rows;
        this.maxSeats = 10 * rows;
        setSeats();
    }

    public void setSeats() {
        this.seats = new char[this.rows][10];
        for (int i = 0; i < this.rows; i++) {
            seats[i][0] = 'A';
            seats[i][1] = 'B';
            seats[i][2] = 'C';
            seats[i][3] = 'D';
            seats[i][4] = 'E';
            seats[i][5] = 'F';
            seats[i][6] = 'G';
            seats[i][7] = 'H';
            seats[i][8] = 'I';
            seats[i][9] = 'J';
        }

    }

    public char[][] getSeats() {
        return this.seats;
    }

    public void printSeats() {
        System.out.println("Row");
        for (int i = 0; i < this.seats.length; i++) {
            System.out
                    .println((i + 1) + "  " + seats[i][0] + " " + seats[i][1] + " " + seats[i][2] + "   " +
                            seats[i][3] + " " + seats[i][4] + " " + seats[i][5] + " " + seats[i][6] + "   " +
                            seats[i][7] + " " + seats[i][8] + " " + seats[i][9]);

        }
        int numberOfSeatsIFlights = (this.getCapacity() - this.bookedSeats);
        System.out.println("There are " + numberOfSeatsIFlights + " seats available.");

    }

    public String getName() {
        return this.name;

    }

    public int getCapacity() {
        return this.maxSeats;
    }

    public int getBooked() {
        return this.bookedSeats;
    }

    public void bookSeat(Flight f, Customer c) {
        this.bookedSeats++;
    }

    @Override
    public String toString() {
        return "Airplane Information: \t" + this.name + "\tCapacity: "
                + this.maxSeats + " seats";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AirPort)) {
            return false;
        }
        AirPlane ap = (AirPlane) obj;
        return this.name.equals(ap.name) && this.modelNumber.equals(ap.modelNumber);
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.rows;
        result = 31 * result + this.modelNumber.hashCode();
        return result;

    }
}
