package com.solvd.airport.classes.entity;

import com.solvd.airport.classes.service.Display;
import com.solvd.airport.exceptions.*;
import com.solvd.airport.classes.service.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Customer extends User {
    public HashMap<Integer, Ticket> tickets = new HashMap<>();
    public Customer(String fullName, String DOB) throws InvalidDateException {
        super(fullName, DOB);
        this.tickets = new HashMap<>();
        HashMap<User, ArrayList<Ticket>> ticketsBooked = Booking.getBookedTickets();
        ticketsBooked.put(this, new ArrayList<Ticket>());
        Display.greeting(this);
    }

    public void addTicket(Ticket t) {
        this.tickets.put(t.hashCode(), t);
    }

    public List getTickets() {
        return this.tickets.values().stream().collect((Collectors.toList()));

    }
    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public String getDOB() {
        return this.birthDate;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \t DOB: %s \n", this.fullName, this.getDOB());
    }
}
