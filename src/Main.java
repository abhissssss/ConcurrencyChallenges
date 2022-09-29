import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
BankAccount myAccount = new BankAccount("9870214102" , 1000 );
new Thread(() -> {
    lock.lock();
    try{
        System.out.println("The new balance after deposit is: " + myAccount.deposit(2010.98));
        System.out.println("The new balance after withdrawal is: " + myAccount.withdraw(50.65));
    }finally {
        lock.unlock();
    }
}).start();

new Thread(() -> {
    lock.lock();
    try {

        System.out.println("New balance after deposit is: " + myAccount.deposit(573.76));
        System.out.println("New balance after withdrawal is: " + myAccount.withdraw(213.91));
    }finally {
        lock.unlock();
    }
}).start();
    }
}