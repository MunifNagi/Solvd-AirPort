package com.solvd.airport.classes.service;

import com.solvd.airport.AirportApplication;
import com.solvd.airport.exceptions.*;
import com.solvd.airport.classes.entity.*;
import com.solvd.airport.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Booking Tickets for user's chosen flights
 * and printing them.
 */
public class Booking implements BookSeat, IConfirmation {

    private static final Logger logger = LogManager.getLogger(Booking.class);
    static HashMap<User, ArrayList<Ticket>> ticketsBooked = new HashMap<>();

    public static void checkAvailability(AirPlane p){
        int bookedSeats = p.getBooked();
        int capacity = p.getCapacity();
        if(!(bookedSeats < capacity)) {
            System.out.println("There are no available seats. Please choose a different Flight");
        }
    }

    public static String chooseSeat(AirPlane p) {
        System.out.println("Please enter the seat (such as '1A') you like to book.");
        System.out.println("Enter -1 to cancel.");
        p.printSeats();
        Scanner keyboard = new Scanner(System.in);
        String seatNumber=null;
        int row;
        int col;
        do {
            if(seatNumber != null) {
                System.out.println("Input error. Enter seat to assign (such as '1A'), or -1 to cancel.");
            }
            seatNumber = keyboard.nextLine();
            if(seatNumber.equals("-1")) {
                return "-1";
            }
            if(!(seatNumber.length() == 2)) {
                row=-1;
                col=-1;
            } else {
                row = seatNumber.charAt(0) - '1';
                col = seatNumber.charAt(1) - 'A';
            }
        } while ((row < 0 || row >= p.getRows()) || (col < 0 || col >= p.getCols()));
        return seatNumber;
    }

    public void bookSeat(Flight flight, Customer customer) {
        if(flight == null) {
            throw new NoFlightChosenException("Flight is null, so there will be no AirPlane associated with it to book", new NullPointerException());
        }
        AirPlane plane = flight.getAirPlane();;
        checkAvailability(plane);
        String seatNumber = chooseSeat(plane);
        if(seatNumber == "-1") {
            System.out.println("Thank you!\n");
            return;
        }
        char[][] seats = plane.getSeats();
        int row = seatNumber.charAt(0) - '1';
        int col = seatNumber.charAt(1) - 'A';
        if(seats[row][col] != 'X') {
            seats[row][col] = 'X';
            Ticket t = new Ticket(customer, flight, seatNumber);
            customer.addTicket(t);
            ticketsBooked.get(customer).add(t);
            plane.bookSeat(null, null);
            System.out.println(" ");
            try {
                IConfirmation.confirm(customer, plane, seatNumber, true);
                logger.info("Booking is confirmed and has been written to file.");
            } catch(IOException e) {
                logger.error("Confirmation of booking was not successful");
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("This seat is taken. Try Again");
            bookSeat(flight, customer);
        }
    }

    public static void printAllTickets() {
        for(Map.Entry<User, ArrayList<Ticket>> m : ticketsBooked.entrySet()){
            System.out.println(m.getKey());
            Display.print(m.getValue());
            System.out.println("_________");
        }
    }

    public static HashMap<User, ArrayList<Ticket>> getBookedTickets() {
        return ticketsBooked;
    }
}
