package com.solvd.airport.interfaces;

import com.solvd.airport.classes.entity.AirPlane;
import com.solvd.airport.classes.entity.Customer;
import com.solvd.airport.classes.service.Seating;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public interface IConfirmation {
    static void confirm(Customer customer, AirPlane airPlane, String seatNumber, boolean booked) throws IOException {
        Random rand = new Random();
        int confirmationNumber = rand.nextInt(999999);
        String confirmation;
        String name = customer.getFullName();
        String fileName = String.format("%s#%06d.text", name, confirmationNumber);
        File file = new File(fileName);
        FileUtils.writeStringToFile(file, String.format("Confirmation#%06d\n", confirmationNumber), Charset.defaultCharset());
        Seating.appendStringToFile(file, customer.toString());
        confirmation = String.format("Your confirmation number is #%06d, Please check the file %s for confirmation.", confirmationNumber, fileName);
        System.out.println(confirmation);
        if(!(booked)) {
            confirmation = String.format("The ticket with the seat number %s is canceled.\n", seatNumber);
            System.out.println(confirmation);
            Seating.appendStringToFile(file, confirmation);
            FileUtils.writeStringToFile(file, "The seat below marked below has been cancelled\n", Charset.defaultCharset(), true);
        } else {
            confirmation = String.format("you are booked, your seat is %s\n", seatNumber);
            System.out.println(confirmation);
            Seating.appendStringToFile(file, confirmation);
            Seating.appendStringToFile(file, "Thank you, the seat marked below is now yours\n");
        }
        char[][] seats = Seating.getSeats(airPlane);
        int row = seatNumber.charAt(0) - '1';
        int col = seatNumber.charAt(1) - 'A';
        seats[row][col] = 'X';
        Seating.writeSeats(seats, file);
        Seating.appendStringToFile(file, customer.getFullName());
        Seating.appendStringToFile(file, " Tickets\n");
        List tickets = customer.getTickets();
        FileUtils.writeLines(file, tickets,true);
    }

}
