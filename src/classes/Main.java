package classes;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.Provider;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.trace("Starting The Applications");

        AirPort Ezeiza = new AirPort("Ezeiza", " Buenos Aires");
        AirPort JFK = new AirPort("JFK", "New York");
        AirPort LHR = new AirPort("LHR", "London");

        AirPlane Boeing = new AirPlane("Boeing", "1234", 7);
        AirPlane Boeing2 = new AirPlane("Boeing", "1235", 4);
        AirPlane Boeing3 = new AirPlane("Boeing", "1236", 5);

        Flight f1 = new Flight(JFK, Ezeiza, 7, Boeing);
        Flight f2 = new Flight(JFK, LHR, 9, Boeing2);
        Flight f3 = new Flight(JFK, LHR, 9, Boeing3);
//        JFK.getAllFlights();
//        JFK.getAllAirPlanes();
        Employee user1 = new Employee("John","10/22/1980", JFK);
        Customer user2 = new Customer("Alex","6/18/1997");
        user1.greeting();
        user2.greeting();
        Flight chosen = user1.chooseFlight();
        if (chosen == null){
            logger.warn("No Flight has been chosen");
        }
        user1.bookTicket(chosen, user2);
        user2.getTickets();
        logger.info("Exiting application.");
    }
}
