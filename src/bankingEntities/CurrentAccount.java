package bankingEntities;

import exceptions.AccountNotFoundException;
import exceptions.InsufficientFundsException;
import operations.Transferable;

import java.math.BigDecimal;

public class CurrentAccount extends Account implements Transferable {

    //maximum negative balance that an account can reach
    private double overdraftLimit;
    private String name;

    public CurrentAccount(String name) {
        super();
        this.name = name;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void transferMoney(int amount, Account destinationAccount) throws InsufficientFundsException, AccountNotFoundException {

        if (destinationAccount == null) {
            throw new AccountNotFoundException("Destination account not found.");
        }

        if (getBalance().compareTo(new BigDecimal(amount)) >= 0) {

            BigDecimal withdrawalAmount = withdraw(new BigDecimal(amount));
            destinationAccount.deposit(withdrawalAmount);
        } else {
            throw new InsufficientFundsException("Insufficient funds for the transfer.");
        }
    }
}
