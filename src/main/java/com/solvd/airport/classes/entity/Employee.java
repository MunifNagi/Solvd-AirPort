package com.solvd.airport.classes.entity;

import com.solvd.airport.Exceptions.*;
import com.solvd.airport.interfaces.*;
import com.solvd.airport.classes.service.Display;
import com.solvd.airport.classes.service.Booking;
import com.solvd.airport.classes.service.Cancellation;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends User {
    private AirPort employer;
    public Employee(String fullName, String DOB, AirPort ap) throws InvalidDateException {
        super(fullName, DOB);
        this.employer = ap;
        greeting();
    }

    @Override
    public String getFullName() {
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
        System.out.println("I'm an employee in this Airport");
    }

    public Flight chooseFlight() {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        try {
            flights = this.employer.getDepartingFlights();
        } catch(NullPointerException e) {
            System.out.println("Airport is null, so there are no flights");
            return null;
        }
        System.out.println("Airport flights");
        Display.numberedPrint(flights);

        System.out.println("Please enter the Flight you wish to Book.");
        Scanner keyboard = new Scanner(System.in);
        String chosen = keyboard.nextLine();
        try {
            int index = Integer.parseInt(chosen);
            return flights.get(index - 1);
        } catch(NumberFormatException nfe) {
            System.out.println(chosen + " is not a number");
        } catch(IndexOutOfBoundsException ioobe) {
            System.out.println("Index " + (Integer.parseInt(chosen) - 1) +" is out of bound");
        }
        return null;
    }

    public void bookTicket(Flight f, Customer c) {
        Booking b = new Booking();
        b.bookSeat(f, c);
    }

    public Ticket chooseTicket(Customer customer) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        try {
            tickets = (ArrayList<Ticket>) customer.getTickets();
        } catch(NullPointerException e) {
            System.out.println("You have no tickets to cancel");
            return null;
        }
        System.out.println(customer.getFullName()+"'s Tickets");
        Display.numberedPrint(tickets);
        System.out.println("Please enter the Ticket you wish to cancel.");
        Scanner keyboard = new Scanner(System.in);
        String chosen = keyboard.nextLine();
        Ticket ticketToCancel = null;
        try {
            int index = Integer.parseInt(chosen);
            ticketToCancel = tickets.get(index - 1);
        } catch(NumberFormatException nfe) {
            System.out.println(chosen + " is not a number");
        } catch(IndexOutOfBoundsException ioobe) {
            System.out.println("Index " + (Integer.parseInt(chosen) - 1) +" is out of bound");
        }
        if(ticketToCancel == null) {
            System.out.println("Lets Try again");
            ticketToCancel = chooseTicket(customer);
            return ticketToCancel;
        }
        return ticketToCancel;
    }

    public void cancelTicket(Customer customer) {
        Ticket ticket = chooseTicket(customer);
        Cancellation.cancelTicket(customer, ticket);
    }
}
