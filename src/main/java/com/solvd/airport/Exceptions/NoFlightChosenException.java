package com.solvd.airport.Exceptions;

public class NoFlightChosenException extends RuntimeException{
    public NoFlightChosenException(){
    }

    public NoFlightChosenException(String message) {
        super(message);
    }

    public NoFlightChosenException(Throwable cause) {
        super(cause);
    }

    public NoFlightChosenException(String message,Throwable cause) {
        super(message,cause);
    }

}
