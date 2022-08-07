package interfaces;
import classes.Flight;

import java.util.*;

public interface IFlights {
    void printAllFlights();

    void addFlight(Flight F, ArrayList<Flight> Flights);
}
