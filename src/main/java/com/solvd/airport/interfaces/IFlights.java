package com.solvd.airport.interfaces;
import com.solvd.airport.classes.entity.Flight;

import java.util.*;

public interface IFlights {
    void printAllFlights();

    void addFlight(Flight F, ArrayList<Flight> Flights);
}
