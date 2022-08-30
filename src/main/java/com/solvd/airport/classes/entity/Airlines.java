package com.solvd.airport.classes.entity;

import com.solvd.airport.classes.service.Booking;
import com.solvd.airport.classes.service.Display;
import com.solvd.airport.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.*;

public class Airlines implements IFlights, IAirPlanes {
    private ArrayList<Flight> flights;
    private ArrayList<AirPlane> airPlanes;
    private String name;

    private static final Logger logger = LogManager.getLogger(Airlines.class);


    public Airlines(String Airlines) {
        this.name = Airlines;
        this.flights = new ArrayList<Flight>();
        this.airPlanes = new ArrayList<AirPlane>();
    }

    public String getName() {
        return this.name;
    }

    public void getAllFlights() {
        System.out.println("Airlines flights");
        Display.print(this.flights);
    }

    public void getAllAirPlanes() {
        System.out.println("Airlines Airplanes");
        Display.print(this.airPlanes);
    }

    public void addFlight(Flight flight, ArrayList<Flight> flights) {
        this.flights.add(flight);
    }

    public void addAirPlane(AirPlane plane) {
        this.airPlanes.add(plane);
    }

    public void overrideFlightPlane( Flight flight, AirPlane newAirPlan) {
        if(flight.getAirPlane().getBooked() > 0) {
            logger.warn("Flight Airplane was not changed");
            System.out.println("This Airplane has booked seats already, you can not modify the flight airplane at this time");
        } else {
            Field[] flightFields = flight.getClass().getDeclaredFields();
            Arrays.stream(flightFields)
                    .filter(field -> field.getName() == "airPlane")
                    .forEach(plane -> {
                        plane.setAccessible(true);
                        try {
                            plane.set(flight, newAirPlan);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}
