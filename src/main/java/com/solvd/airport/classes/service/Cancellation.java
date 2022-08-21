package com.solvd.airport.classes.service;

import com.solvd.airport.classes.entity.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Removing tickets from booked tickets and customer's tickets
 * and marking the seat in the airplane unused
 */
public class Cancellation {
    public static void cancelTicket(Customer customer, Ticket t){
        customer.tickets.remove(t.hashCode());
        HashMap<User, ArrayList<Ticket>> ticketsBooked = Booking.getBookedTickets();
        ticketsBooked.get(customer).remove(t);
        Seat seat = t.getSeat();
        Flight flight = t.getFlight();
        AirPlane plane = flight.getAirPlane();
        plane.emptySeat(seat);
        String confirmation = String.format("The ticket with the seat number %s%s is canceled.", seat.getNum(),seat.getLetter());
        System.out.println(confirmation);
    }
}
