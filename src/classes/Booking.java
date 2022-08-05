package classes;

import interfaces.BookSeat;

import java.util.Scanner;

public class Booking implements BookSeat {
    public void bookSeat(Flight f, Customer customer) {
        AirPlane p = f.getAirPlane();
        int bookedSeats = p.getBooked();
        int capacity = p.getCapacity();
        char[][] seats = p.getSeats();
        if (!(bookedSeats < capacity)) {
            System.out.println("There are no available seats, Please choose a different Flight");
        }
        System.out.println("Please enter the seat (such as '1A') you like to book.");
        System.out.println("Enter -1 to cancel.");
        p.printSeats();
        Scanner keyboard = new Scanner(System.in);
        String seatNumber = keyboard.nextLine();
        if (seatNumber.equals("-1")) {
            System.out.println("Thank you!\n");
            return;
        }
        while (bookedSeats < capacity && seatNumber.length() > 1) {
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';
            if (row < 0 || row > ((capacity / 10) - 1) || col < 0 || col > 9) {
                System.out.println("Input error. Enter seat to assign (such as '1A')," + "or -1 to cancel.");
                seatNumber = keyboard.nextLine();
                if (seatNumber.equals("-1")) {
                    System.exit(0);
                }
            } else {
                if (seats[row][col] != 'X') {
                    seats[row][col] = 'X';
                    Ticket t = new Ticket(customer, f, seatNumber);
                    customer.addTicket(t);
                    p.bookSeat();
                    bookedSeats = p.getBooked();
                    System.out.println(" ");
                    p.printSeats();
                    System.out.println("you are booked, your seat is " + seatNumber);
                    break;
                } else {
                    System.out.println("This seat is taken. Choose a different seat to assign " + "or c to cancel.");
                    seatNumber = keyboard.nextLine();

                }
            }
        }
    }
}
