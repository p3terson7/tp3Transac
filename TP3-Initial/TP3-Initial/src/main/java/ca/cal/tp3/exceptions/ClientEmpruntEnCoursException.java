package ca.cal.tp3.exceptions;

public class ClientEmpruntEnCoursException extends Exception {
    public ClientEmpruntEnCoursException() {
        super("Veuillez retourner vos documents avant de re-emprunter!");
    }
}
