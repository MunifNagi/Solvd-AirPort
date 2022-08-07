package classes;

import interfaces.BookSeat;
import java.util.Scanner;

public class Booking implements BookSeat {
    public static void checkAvailability(AirPlane p){
        int bookedSeats = p.getBooked();
        int capacity = p.getCapacity();
        if (!(bookedSeats < capacity)) {
            System.out.println("There are no available seats, Please choose a different Flight");
        }
    }
    public static String chooseSeat(AirPlane p) {
        System.out.println("Please enter the seat (such as '1A') you like to book.");
        System.out.println("Enter -1 to cancel.");
        p.printSeats();
        Scanner keyboard = new Scanner(System.in);
        String seatNumber=null;
        int row;
        int col;
        do {
            if (seatNumber!=null){System.out.println("Input error. Enter seat to assign (such as '1A')," + "or -1 to cancel.");}
            seatNumber = keyboard.nextLine();
            if (seatNumber.equals("-1")) {
                System.out.println("Thank you!\n");
                return "-1";
            }
            if (!(seatNumber.length() == 2)) {
                row=-1;
                col=-1;
            }else {
                row = seatNumber.charAt(0) - '1';
                col = seatNumber.charAt(1) - 'A';
            }
        } while (row < 0 || row > ((p.getCapacity() / 10) - 1) || col < 0 || col > 9);
        return seatNumber;
    }
    public void bookSeat(Flight f, Customer customer) {
        AirPlane p;
        try {
            p = f.getAirPlane();
        }catch(NullPointerException npe){
            System.out.println("Flight is null, so there will be no planes associated with it to book");
            return;
        }
        checkAvailability(p);
        String seatNumber=chooseSeat(p);
        char[][] seats = p.getSeats();
        int row = seatNumber.charAt(0) - '1';
        int col = seatNumber.charAt(1) - 'A';
        if (seats[row][col] != 'X') {
            seats[row][col] = 'X';
            Ticket t = new Ticket(customer, f, seatNumber);
            customer.addTicket(t);
            p.bookSeat(null,null);
            System.out.println(" ");
            p.printSeats();
            System.out.println("you are booked, your seat is " + seatNumber);
        } else {
            System.out.println("This seat is taken. Try Again");
            bookSeat(f,customer);
        }
    }
}