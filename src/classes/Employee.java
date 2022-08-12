package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends User {
    private AirPort airport;
    public Employee(String fullName, String DOB, AirPort ap) {
        super(fullName,DOB);
        airport = ap;
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
        ArrayList<Flight> flights = this.airport.getDepartingFlights();
        System.out.println("Airport flights");
        for (int i = 1; i < flights.size() + 1; i++) {
            System.out.println(i + "-" + flights.get(i - 1) + " ");
        }
        System.out.println("Please enter the Flight you wish to Book.");

        Scanner keyboard = new Scanner(System.in);
        int chosen = (Integer.parseInt(keyboard.nextLine()));
        if (chosen > flights.size()){
            return  null;
        }
        return flights.get(chosen - 1);
    }

    void bookTicket(Flight f, Customer c) {
        Booking b = new Booking();
        b.bookSeat(f, c);
    }
    }

    

    

    

    





