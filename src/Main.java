import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
BankAccount myAccount = new BankAccount("9870214102" , 1000 );
new Thread(() -> {
        System.out.println("The new balance after deposit is: " + myAccount.deposit(200));
        System.out.println("The new balance after withdrawal is: " + myAccount.withdraw(50));


}).start();

new Thread(() -> {
        System.out.println("New balance after deposit is: " + myAccount.deposit(500));
        System.out.println("New balance after withdrawal is: " + myAccount.withdraw(300));

}).start();
    }
}