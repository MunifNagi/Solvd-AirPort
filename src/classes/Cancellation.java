package classes;

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
