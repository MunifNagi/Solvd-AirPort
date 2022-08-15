package classes.service;

import classes.entity.Customer;
import classes.entity.Flight;
import classes.entity.Seat;
import classes.entity.Ticket;
import classes.entity.AirPlane;

public class Cancellation {
    public static void cancelTicket(Customer customer, Ticket t){
        //removing tickets from booked tickets and customer's tickets
        customer.tickets.remove(t.hashCode());
        Booking.ticketsBooked.get(customer).remove(t);

        //getting ticket seat and mark seat in the airplane unused
        Seat seat = t.getSeat();
        Flight flight = t.getFlight();
        AirPlane plane = flight.getAirPlane();
        plane.emptySeat(seat);

    }
}
