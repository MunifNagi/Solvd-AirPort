package com.solvd.airport.interfaces;

import com.solvd.airport.classes.entity.Customer;
import com.solvd.airport.classes.entity.Flight;

public interface BookSeat {
     void bookSeat(Flight f, Customer c);
}
