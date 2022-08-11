package classes;

import interfaces.IAirPlanes;
import interfaces.IFlights;

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

    public void printAllFlights() {
        System.out.println("Airlines flights");
        Display.print(this.flights);
    }
    public void printAllAirPlanes() {
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
