import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private final String accountNumber;
    private double balance;
    private Lock reentrantLock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.reentrantLock = new ReentrantLock();
    }


    public double deposit(double amount) {
        try {
            if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println("Could not get the lock too");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return amount;

    }

    public double withdraw(double amount) {
        try {
            if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public String getAccountNumber() {

        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number is: " + this.accountNumber);
    }
}
