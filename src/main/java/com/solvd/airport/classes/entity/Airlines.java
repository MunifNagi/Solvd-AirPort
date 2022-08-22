package com.solvd.airport.classes.entity;

import com.solvd.airport.classes.service.Display;
import com.solvd.airport.interfaces.*;

import java.util.*;

public class Airlines implements IFlights, IAirPlanes {
    private ArrayList<Flight> flights;
    private ArrayList<AirPlane> airPlanes;
    private String name;

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
        flights.add(flight);
    }

    public void addAirPlane(AirPlane plane) {
        this.airPlanes.add(plane);
    }

}
