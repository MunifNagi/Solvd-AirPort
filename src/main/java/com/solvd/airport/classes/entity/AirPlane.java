package com.solvd.airport.classes.entity;

import com.solvd.airport.classes.service.Seating;
import com.solvd.airport.exceptions.*;
import com.solvd.airport.interfaces.*;

public class AirPlane implements BookSeat, ISeats {
    private String name;
    private String modelNumber;
    private int capacity;
    private int rows;
    private int cols;
    private int bookedSeats;
    private char[][] seats;

    public AirPlane(String planeName, String model, int rows, int cols) {
        this.name = planeName;
        this.modelNumber = model;
        if(rows < 1 || cols < 1) {
            throw new NegativeArgumentValueException("Airplane contains negative number of rows or cols!");
        }
        this.rows = rows;
        this.cols = cols;
        this.capacity = cols * rows;
        this.seats = new char[rows][cols];
        setSeats();
    }

    public void setSeats() {
        Seating.setSeats(this.seats);
    }

    public char[][] getSeats() {
        return this.seats;
    }

    public void printSeats() {
        Seating.printSeats(this.seats);
        int numberOfSeatsIFlights = (this.getCapacity() - this.bookedSeats);
        System.out.println("There are " + numberOfSeatsIFlights + " seats available.");
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public int getBooked() {
        return this.bookedSeats;
    }

    public void emptySeat(Seat seat) {
        this.bookedSeats--;
        int row = seat.getNum() - '1';
        int col = seat.getLetter() - 'A';
        this.seats[row][col] = seat.getLetter();
    }

    public void bookSeat(Flight f, Customer c) {
        this.bookedSeats++;
    }

    @Override
    public String toString() {
        return String.format("Airplane Information: %s \t Capacity: %s seats", this.name, this.capacity);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof AirPort)) {
            return false;
        }
        AirPlane ap = (AirPlane) obj;
        return this.name.equals(ap.name) && this.modelNumber.equals(ap.modelNumber);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.rows;
        result = 31 * result + this.modelNumber.hashCode();
        return result;
    }
}
