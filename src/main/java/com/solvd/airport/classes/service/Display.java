package com.solvd.airport.classes.service;

import com.solvd.airport.classes.entity.AirPlane;
import com.solvd.airport.classes.entity.Customer;
import com.solvd.airport.classes.entity.Employee;
import com.solvd.airport.classes.entity.User;

import java.util.Iterator;
import java.util.List;

/**
 * Class to display list of objects to the console
 */
public abstract class Display {

    public static void print(List<?> objects) {
        for (Iterator iter = objects.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }

    public static void numberedPrint(List<?> objects) {
        int i = 0;
        for (Iterator iter = objects.iterator(); iter.hasNext();) {
            System.out.println(++i + "-" + iter.next());
        }
    }

    public static <T extends User> void greeting(T user) {
        System.out.println("Hello my name is " + user.getFullName());
        System.out.println("DOB: " + user.getDOB());
        if(user instanceof Customer) {
            System.out.println("I'm a customer");
        } else if(user instanceof Employee) {
            System.out.println("I'm an employee in this Airport");
        }
    }

}
