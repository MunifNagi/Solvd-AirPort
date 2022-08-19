package com.solvd.airport.classes.entity;

import com.solvd.airport.Exceptions.*;
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
        Booking.ticketsBooked.put(this, new ArrayList<Ticket>());
        greeting();
    }

    public void addTicket(Ticket t) {
        this.tickets.put(t.hashCode(),t);
    }

    public List getTickets() {
        //getting a list of all the customer tickets
        return  this.tickets.values().stream().collect((Collectors.toList()));

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
