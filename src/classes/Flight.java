package classes;

import Exceptions.NegativeArgumentValueException;

public class Flight {
    private AirPlane airPlane;
    private AirPort origin;
    private AirPort destination;
    public int cost;

    public Flight(AirPort ori, AirPort des, int cost, AirPlane plane) {
        this.origin = ori;
        this.destination = des;
        if (cost < 0){
            throw new NegativeArgumentValueException("Cost for the flight can not be negative");
        }
        this.cost = cost;
        this.airPlane = plane;
        this.origin.addFlight(this, origin.departingFlights);
        this.destination.addFlight(this, destination.arrivingFlights);
        this.origin.addAirPlane(plane);
    }

    public String toString() {
        return "Flight Information:\t"
                + this.airPlane.getName() + "\tFrom: " + this.origin.getCity() + " to " + this.destination.getCity();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Flight)) {
            return false;
        }
        Flight f = (Flight) obj;
        return this.origin.equals(f.getSource()) && this.airPlane.equals(f.getAirPlane()) && this.destination.equals(f.getDestination()) ;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + this.origin.hashCode();
        result = 31 * result + this.cost;
        result = 31 * result + this.destination.hashCode();
        return result;

    }

    public AirPort getSource() {
        return this.origin;
    }

    public AirPort getDestination() {
        return this.destination;
    }

    public AirPlane getAirPlane() {
        return this.airPlane;
    }

}
