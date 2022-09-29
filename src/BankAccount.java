public class BankAccount {

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }


    //    public synchronized double deposit(double amount){
//
//        if (amount<=0){
//            System.out.println("Cannot add such amount");
//        }
//        return this.balance+=amount;
//    }
    public double deposit(double amount) {
        synchronized (this) {
            if (amount <= 0) {
                System.out.println("Cannot add such amount");
            }
            return this.balance += amount;
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
        synchronized (this){
            if (amount > balance) {
                System.out.println("Insufficient balance");
            }
            return this.balance -= amount;

        }
        }

}
