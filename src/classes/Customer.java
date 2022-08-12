package classes;

import Exceptions.InvalidDateException;

import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Ticket> tickets;
    public Customer(String fullName, String DOB) throws InvalidDateException {
        super(fullName,DOB);
        this.tickets = new ArrayList<Ticket>();
        Booking.ticketsBooked.put(this,new ArrayList<Ticket>());
    }

    public void addTicket(Ticket t) {
        this.tickets.add(t);
    }

    public void getTickets() {
        System.out.println(this.fullName + "'s Tickets");
        Display.print(this.tickets);

    }
    @Override
    String getFullName() {
        return this.fullName;
    }
    @Override
    String getDOB() {
        return this.birthDate;
    }
    @Override
    void greeting() {
        System.out.println("Hello my name is " + this.fullName);
        System.out.println("DOB: " + this.birthDate);
        System.out.println("I'm a customer");
    }
    @Override
    public String toString() {
        return "Name: " + this.fullName + "   " + " DOB: " + this.getDOB();
    }

}
