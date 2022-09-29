

public class Main {
    public static void main(String[] args) {

        MyBankAccount myAccount = new MyBankAccount("9870214102", 1000);
        new Thread(() -> {
            System.out.println("The new balance after deposit is: " + myAccount.deposit(201.98));
            System.out.println("The new balance after withdrawal is: " + myAccount.withdraw(50.65));
        }).start();

        new Thread(() -> {

            System.out.println("New balance after deposit is: " + myAccount.deposit(573.76));
            System.out.println("New balance after withdrawal is: " + myAccount.withdraw(213.91));
        }).start();
    }
}