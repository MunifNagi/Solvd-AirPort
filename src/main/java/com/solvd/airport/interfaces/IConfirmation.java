package com.solvd.airport.interfaces;

import com.solvd.airport.classes.entity.AirPlane;
import com.solvd.airport.classes.service.Seating;

public interface IConfirmation {
    static void confirm(AirPlane airPlane, String seatNumber, boolean booked) {
        String confirmation;
        if(!(booked)) {
            confirmation = String.format("The ticket with the seat number %s is canceled.", seatNumber);
            System.out.println(confirmation);
            System.out.println("The seat below marked below has been cancelled");
        } else {
            confirmation = String.format("you are booked, your seat is " + seatNumber);
            System.out.println(confirmation);
            System.out.println("Thank you, the seat marked below is now yours");
        }
        char[][] seats = Seating.getSeats(airPlane);
        int row = seatNumber.charAt(0) - '1';
        int col = seatNumber.charAt(1) - 'A';
        seats[row][col] = 'X';
        Seating.printSeats(seats);
    }

}
