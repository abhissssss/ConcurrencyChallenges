import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private final String accountNumber;
    private double balance;


    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }


    public double deposit(double amount) {
    if (amount<=0){
        System.out.println("Cannot add this amount");
    }
      return this.balance+=amount;
    }

    public double withdraw(double amount) {
if (amount>balance){
    System.out.println("Insufficient funds cannot withdraw");
} return this.balance-=amount;
    }
    public String getAccountNumber() {

        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number is: " + this.accountNumber);
    }
}
