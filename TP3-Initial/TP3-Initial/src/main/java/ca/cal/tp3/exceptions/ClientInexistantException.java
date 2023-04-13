package ca.cal.tp3.exceptions;

public class ClientInexistantException extends Exception {
    public ClientInexistantException() {
        super("Ce client est inexistant!");
    }
}
