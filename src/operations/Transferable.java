package operations;

import bankingEntities.Account;
import exceptions.AccountNotFoundException;
import exceptions.InsufficientFundsException;

public interface Transferable {

    void transferMoney(int amount, Account destinationAccount) throws InsufficientFundsException, AccountNotFoundException;
}