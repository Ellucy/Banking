package exceptions;

public class AccountNotFoundException extends Exception {

    //constructor
    public AccountNotFoundException() {
        super("Account not found.");
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

}
