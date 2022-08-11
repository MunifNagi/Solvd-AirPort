package classes;

import interfaces.IAirPlanes;
import interfaces.IFlights;

import java.util.*;

public class AirPort implements IFlights, IAirPlanes {
    private String name;
    private String city;
    public ArrayList<Flight> departingFlights;
    public ArrayList<Flight> arrivingFlights;
    public ArrayList<AirPlane> airPlanes;

    public AirPort(String name, String city) {
        this.name = name;
        this.city = city;
        this.departingFlights = new ArrayList<Flight>();
        this.arrivingFlights = new ArrayList<Flight>();
        this.airPlanes= new ArrayList<AirPlane>();
    }

    @Override
    public String toString() {
        return "\nAirport Information:" + "\tName: " + name + "\tcity: " + city;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AirPort)) {
            return false;
        }
        AirPort ap = (AirPort) obj;
        return this.toString().equals(ap.toString());
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.city.hashCode();
        return result;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Flight> getDepartingFlights() {
        return departingFlights;
    }

    public void addFlight(Flight flight, ArrayList<Flight> f) {
        f.add(flight);
    }

    public void printAllFlights() {
        if (departingFlights.size() == 0) {
            System.out.println("No Departing flights from " + name);
        } else {
            System.out.println("Departing flights from " + name);
            Display.print(this.departingFlights);
        }
        if (arrivingFlights.size() == 0) {
            System.out.println("No arriving flights from " + name + "\n");
        } else {
            System.out.println("Arriving flights from " + name);
            Display.print(this.arrivingFlights);
        }

    }

    public void printAllAirPlanes() {
        System.out.println("Airplanes in airport now");
        Display.print(this.airPlanes);
    }

    public void addAirPlane(AirPlane plane) {
        this.airPlanes.add(plane);
    }

}
