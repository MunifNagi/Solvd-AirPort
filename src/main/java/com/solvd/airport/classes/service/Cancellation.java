package com.solvd.airport.classes.service;

import com.solvd.airport.classes.entity.*;
import com.solvd.airport.interfaces.IConfirmation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Removing tickets from booked tickets and customer's tickets
 * and marking the seat in the airplane unused
 */
public class Cancellation implements IConfirmation {

    private static final Logger logger = LogManager.getLogger(Cancellation.class);
    public static void cancelTicket(Customer customer, Ticket t){
        customer.tickets.remove(t.hashCode());
        HashMap<User, ArrayList<Ticket>> ticketsBooked = Booking.getBookedTickets();
        ticketsBooked.get(customer).remove(t);
        Seat seat = t.getSeat();

        Flight flight = t.getFlight();
        AirPlane plane = flight.getAirPlane();
        plane.emptySeat(seat);
        String seatNumber = seat.getSeatNumber();
        try {
            IConfirmation.confirm(customer, plane, seatNumber, false);
            logger.info("Cancellation is confirmed and has been written to file.");
        } catch(IOException e) {
            logger.error("Cancellation of booking was not successful");
            throw new RuntimeException(e);

        }
    }
}
