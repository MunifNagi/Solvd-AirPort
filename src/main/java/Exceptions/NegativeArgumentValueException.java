package Exceptions;

public class NegativeArgumentValueException extends  IllegalArgumentException{
    public NegativeArgumentValueException(){};
    public NegativeArgumentValueException(String message){super(message);};
    public NegativeArgumentValueException(Throwable cause){super(cause);};
    public NegativeArgumentValueException(String message,Throwable cause){super(message,cause);}
}
