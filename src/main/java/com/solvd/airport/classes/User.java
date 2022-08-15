package com.solvd.airport.classes;


import java.util.ArrayList;

public abstract class User {
    protected String fullName;
    protected  String birthDate;

    public User(String fn, String DOB) {
        this.fullName = fn;
        this.birthDate=DOB;
    }

    abstract String getFullName();
    abstract String getDOB();
    abstract void greeting();
}
