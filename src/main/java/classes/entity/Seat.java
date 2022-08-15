package classes.entity;

public final class Seat {
    private char letter;
    private char num;
    private Flight flight;
    private AirPlane airPlane;

    public Seat(char num, char letter, Flight f) {
        this.letter = letter;
        this.num = num;
        this.flight = f;
        this.airPlane = f.getAirPlane();
    }

    @Override
    public String toString() {
        return this.num + "" + this.letter + "  " + this.flight ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Flight)) {
            return false;
        }
        Seat s  = (Seat) obj;
        return this.letter == s.getLetter() && this.airPlane.equals(s.getAirPlane()) && this.num == s.getNum() ;
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + this.letter;
        result = 31 * result + this.num;
        result = 31 * result + this.airPlane.hashCode();
        return result;

    }
    public Flight getFlight() {
        return flight;
    }

    public AirPlane getAirPlane() {
        return this.airPlane;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public char getNum() {
        return num;
    }

    public void setNum(char num) {
        this.num = num;
    }

}
