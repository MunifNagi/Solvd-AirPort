package interfaces;

import classes.entity.Customer;
import classes.entity.Flight;

public interface BookSeat {

    public void bookSeat(Flight f, Customer c);
}
