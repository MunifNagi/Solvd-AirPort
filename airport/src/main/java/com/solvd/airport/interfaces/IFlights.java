package com.solvd.airport.interfaces;
import com.solvd.airport.classes.Flight;

import java.util.*;

public interface IFlights {
    void getAllFlights();

    void addFlight(Flight F, ArrayList<Flight> Flights);
}
