package com.solvd.airport;

import com.solvd.airport.exceptions.InvalidDateException;
import com.solvd.airport.classes.entity.*;
import com.solvd.airport.classes.service.Booking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AirportApplication {
	private static final Logger logger = LogManager.getLogger(AirportApplication.class);

	public static void run() {

		AirPort Ezeiza = new AirPort("Ezeiza", "Buenos Aires");
		AirPort JFK = new AirPort("JFK", "New York");
		AirPort LHR = new AirPort("LHR", "London");

		AirPlane Boeing = new AirPlane("Boeing", "1234", 7, 4);
		AirPlane Boeing2 = new AirPlane("Boeing", "1235", 4, 3);
		AirPlane Boeing3 = new AirPlane("Boeing", "1236", 9, 10);

		Flight f1 = new Flight(JFK, Ezeiza, 7, Boeing);
		Flight f2 = new Flight(JFK, LHR, 9, Boeing2);
		Flight f3 = new Flight(JFK, LHR, 9, Boeing3);
		
		JFK.getAllFlights();
		JFK.getAllAirPlanes();

		Employee employee = createEmployee("John", "10/22/1980", JFK);
		Customer customer1 = createCustomer("Alex", "06/18/1997");
		Customer customer2 = createCustomer("James", "07/29/1995");

		runBooking(employee,customer1);
		runBooking(employee,customer2);
		runBooking(employee,customer1);

		Booking.printAllTickets();
		employee.cancelTicket(customer1);

		runBooking(employee,customer2);
		Booking.printAllTickets();
	}

	static Customer createCustomer(String fullName, String DOB) {
		Customer customer = null;
		try {
			customer = new Customer(fullName, DOB);
		} catch(InvalidDateException e) {
			logger.error("Invalid BirthDate, user wasn't created");
		}
		return customer;
	}

	static Employee createEmployee(String fullName, String DOB, AirPort airPort) {
		Employee employee = null;
		try {
			employee = new Employee(fullName, DOB, airPort);
		} catch(InvalidDateException e) {
			logger.error("Invalid BirthDate, user wasn't created");
		}
		return employee;
	}

	static void runBooking(Employee employee, Customer customer) {
		Flight chosen = employee.chooseFlight();
		employee.bookTicket(chosen, customer);
	}

}
