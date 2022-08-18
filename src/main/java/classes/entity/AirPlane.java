package classes.entity;

import Exceptions.NegativeArgumentValueException;
import interfaces.BookSeat;

public class AirPlane implements BookSeat {
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
        if (rows < 1 || cols < 1) {
            throw new NegativeArgumentValueException("Airplane contains negative number of rows or cols!");
        }
        this.rows = rows;
        this.cols = cols;
        this.capacity = cols * rows;
        setSeats();
    }

    public void setSeats() {
        this.seats = new char[this.rows][this.cols];
        int firstCol = (int) 'A';
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c <this.cols; c++ ) {
                seats[r][c] = (char) (firstCol + c);
            }
        }
    }

    public char[][] getSeats() {
        return this.seats;
    }

    public void printSeats() {
        System.out.println("Row");
        for (int i = 0; i < this.seats.length; i++) {
            System.out.print((i + 1) + "  ");
            for (int c = 0; c < this.cols; c++){
                System.out.print(seats[i][c]+ " ");
            }
            System.out.println("");
        }
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
        return "Airplane Information: \t" + this.name + "\tCapacity: "
                + this.capacity + " seats";
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
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.rows;
        result = 31 * result + this.modelNumber.hashCode();
        return result;
    }
}
