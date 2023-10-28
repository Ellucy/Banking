package bankingEntities;

import exceptions.AccountNotFoundException;
import exceptions.InsufficientFundsException;
import operations.InterestBearing;
import operations.Transferable;

import java.math.BigDecimal;

public class SavingsAccount extends Account implements InterestBearing, Transferable {

    private double interestRate;
    private String name;

    public SavingsAccount(String name) {
        super();
        this.name = name;
        this.interestRate = 0.0015;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void addInterest(double additionalInterest) {
        interestRate += additionalInterest;
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
