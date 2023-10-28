package exceptions;

public class InsufficientFundsException extends Exception {

    //constructor
    public InsufficientFundsException() {
        super("Insufficient funds.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
