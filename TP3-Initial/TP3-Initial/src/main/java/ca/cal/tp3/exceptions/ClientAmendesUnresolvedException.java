package ca.cal.tp3.exceptions;

public class ClientAmendesUnresolvedException extends Exception{
    public ClientAmendesUnresolvedException() {
        super("Veuillez resoudre votre balance avant de re-emprunter!");
    }
}
