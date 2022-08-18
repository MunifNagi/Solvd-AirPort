package classes;

import Exceptions.InvalidDateException;
import classes.entity.*;
import classes.service.Booking;

public class Main {
    public static void main(String[] args) throws InvalidDateException {

        AirPort Ezeiza = new AirPort("Ezeiza", " Buenos Aires");
        AirPort JFK = new AirPort("JFK", "New York");
        AirPort LHR = new AirPort("LHR", "London");

        AirPlane Boeing = new AirPlane("Boeing", "1234", 7, 4);
        AirPlane Boeing2 = new AirPlane("Boeing", "1235", 4, 3);
        AirPlane Boeing3 = new AirPlane("Boeing", "1236", 9, 10);

        Flight f1 = new Flight(JFK, Ezeiza, 7, Boeing);
        Flight f2 = new Flight(JFK, LHR, 9, Boeing2);
        Flight f3 = new Flight(JFK, LHR, 9, Boeing3);
//        JFK.getAllFlights();
//        JFK.getAllAirPlanes();
        Employee user1 = new Employee("John", "10/22/1980", JFK);
        Customer user2 = new Customer("Alex", "06/18/1997");
        Customer user3 = new Customer("John", "07/29/1995");


        Flight chosen = user1.chooseFlight();
        user1.bookTicket(chosen, user2);

        Flight chosen2 = user1.chooseFlight();
        user1.bookTicket(chosen2, user3);

        Flight chosen3 = user1.chooseFlight();
        user1.bookTicket(chosen3, user2);

        Booking.printAllTickets();
        user1.cancelTicket(user2);

        Flight chosen4 = user1.chooseFlight();
        user1.bookTicket(chosen4, user3);
        Booking.printAllTickets();

    }
}
