package classes;

import Exceptions.InvalidDateException;
import Exceptions.NoFlightChosenException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class User {
    protected String fullName;
    protected  String birthDate;

    public User(String fn, String DOB) throws InvalidDateException {
        this.fullName = fn;
        if(dateValidation(DOB)){
            this.birthDate=DOB;
        }else{this.birthDate=null;}
    }

    abstract String getFullName();
    abstract String getDOB();
    abstract void greeting();
    private static boolean dateValidation (String date) throws InvalidDateException
    {
        DateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);//checks if date actually exists
        try {
            dateFormat.parse(date);
            return true;
        } catch (Exception e) {
            throw new NoFlightChosenException("Date is Invalid",new ParseException("could not parse date",0));
        }
    }


}
