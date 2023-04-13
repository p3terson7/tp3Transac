package ca.cal.tp3.exceptions;

public class ClientAucunEmpruntException extends Exception{
    public ClientAucunEmpruntException() {
        super("Impossible de faire un retour, aucun emprunt en instance!");
    }
}
