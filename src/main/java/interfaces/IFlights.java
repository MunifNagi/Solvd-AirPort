package interfaces;
import classes.entity.Flight;

import java.util.*;

public interface IFlights {
    void printAllFlights();

    void addFlight(Flight F, ArrayList<Flight> Flights);
}
