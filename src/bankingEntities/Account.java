package bankingEntities;

import java.math.BigDecimal;
import java.util.Random;

public abstract class Account {

    private final long accountNumber;
    private BigDecimal balance;

    public Account() {
        long min = 100_000_000_000L;
        long max = 999_999_999_999L;

        Random random = new Random();
        accountNumber = min + (long) (random.nextDouble() * (max - min + 1));

        this.balance = BigDecimal.ZERO;
    }

    public BigDecimal deposit(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
        }
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amount) {

        if (balance.compareTo(amount) >= 0 && amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.subtract(amount);
            return amount;
        }
        return BigDecimal.ZERO; //0 if unsuccessful withdrawal
    }

    public BigDecimal getBalance() {
        return balance;
    }

    //test if account number was created
    public long getAccountNumber() {
        return accountNumber;
    }
}
