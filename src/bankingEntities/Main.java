package bankingEntities;

import exceptions.AccountNotFoundException;
import exceptions.InsufficientFundsException;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InsufficientFundsException, AccountNotFoundException {

        System.out.println("Menu");

        System.out.print("Write your full name to open an bank account: ");
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();

        CurrentAccount account1 = new CurrentAccount(name1);

        System.out.println("Do you also want to create a savings account (yes/no)?");
        String response = scanner.nextLine();

        SavingsAccount savingsAccount1 = null;
        if (Objects.equals(response, "yes")) {
            savingsAccount1 = new SavingsAccount(name1);
        }

        System.out.println("Your current balance in this account (acc nr: " + account1.getAccountNumber() + ") :" + account1.getBalance() + " €");

        account1.deposit(BigDecimal.valueOf(1600));

        System.out.println("Your balance after deposit: " + account1.getBalance() + " €");

        account1.withdraw(BigDecimal.valueOf(200));

        System.out.println("Your balance after withdraw: " + account1.getBalance() + " €");

        if (savingsAccount1 != null) {
            System.out.println("Your current balance in savings account: " + savingsAccount1.getBalance());

            savingsAccount1.deposit(BigDecimal.valueOf(1000));

            System.out.println("Your balance after deposit: " + savingsAccount1.getBalance());

            savingsAccount1.withdraw(BigDecimal.valueOf(100));

            System.out.println("Your balance after withdraw: " + savingsAccount1.getBalance());
        }

        //Creating a new random current account and savings account to test money transfer
        String name = "John Doe";
        CurrentAccount account2 = new CurrentAccount(name);
        SavingsAccount savingsAccount2 = new SavingsAccount(name);

        String line = new String(new char[60]).replace('\0', '-');
        System.out.println(line);

        System.out.println("Before I transferred money to John, John's balance was: " + account2.getBalance() + " €");
        System.out.println("Before I transferred money to John, my balance was: " + account1.getBalance() + " €");

        account1.transferMoney(400, account2);

        System.out.println("After transferring money to John, John's balance is: " + account2.getBalance() + " €");
        System.out.println("After transferring money to John, my balance is: " + account1.getBalance() + " €");

        System.out.println(line);

        //transferring from current to savings account
        System.out.println("Before I transferred money to John savings account, his savings account balance was: " + savingsAccount2.getBalance() + " €");
        System.out.println("Before transferring money to savings account, my savings account balance was: " + account1.getBalance() + " €");

        account1.transferMoney(250, savingsAccount2);

        System.out.println("After I transferred money to John savings account, his savings account balance is: " + savingsAccount2.getBalance() + " €");
        System.out.println("After transferring money to John's savings account, my current balance is: " + account1.getBalance() + " €");

        System.out.println("Default interest rate: " + savingsAccount2.getInterestRate());
        savingsAccount2.addInterest(0.0005);
        System.out.println("New interest rate: " + savingsAccount2.getInterestRate());
    }
}