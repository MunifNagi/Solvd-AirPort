package classes;

public final class Ticket {
    private Customer customer;
    private Flight flight;
    private Seat seat;

    public Ticket(Customer customer, Flight f, String seatNum) {
        this.customer = customer;
        this.flight = f;
        this.seat = new Seat(seatNum.charAt(0), seatNum.charAt(1), f);

    }

    @Override
    public String toString() {
        return this.seat.toString();
    }

    public Seat getSeat() {
        return this.seat;

    }

    public Customer getCustomer() {
        return this.customer;

    }

    public Flight getFlight() {
        return this.flight;
    }
}
