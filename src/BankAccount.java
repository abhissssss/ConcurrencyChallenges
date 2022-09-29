import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private final String accountNumber;
    private double balance;
    private Lock reentrantLock;

    public BankAccount(String accountNumber, double initialBalance ) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.reentrantLock= new ReentrantLock();
    }


    //    public synchronized double deposit(double amount){
//
//        if (amount<=0){
//            System.out.println("Cannot add such amount");
//        }
//        return this.balance+=amount;
//    }
    public double deposit(double amount) {
        reentrantLock.lock();
          try{
              if (amount <= 0) {
                  System.out.println("Cannot add such amount");
              }
              return this.balance += amount;
          }finally {
              reentrantLock.unlock();
          }

        }

//    public synchronized double withdraw(double amount) {
//        if (amount > balance) {
//            System.out.println("Insufficient balance");
//        }
//        return this.balance -= amount;
//
//    }

    public  double withdraw(double amount) {
reentrantLock.lock();
        try {
            if (amount > balance) {
                System.out.println("Insufficient balance");
            }
            return this.balance -= amount;
        } finally {
            reentrantLock.unlock();
        }


        }

    public  String getAccountNumber() {

        return accountNumber;
    }

    public  void printAccountNumber(){
        System.out.println("Account number is: " +this.accountNumber);
    }
}
