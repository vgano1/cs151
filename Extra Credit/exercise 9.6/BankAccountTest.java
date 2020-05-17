import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        int initialBalance;
        int withdrawAmount;
        int depositAmount; 
        int rep;
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hello, please enter your initial bank account balance:");
        initialBalance = scanner.nextInt();
        
        System.out.println("Next, enter your withdrawal amount:");
        withdrawAmount = scanner.nextInt();
        
        System.out.println("Next, enter your deposit amount:");
        depositAmount = scanner.nextInt();
        
        System.out.println("Finally, enter the amount of repetitions in the transactions:");
        rep = scanner.nextInt();
        
        scanner.close();
        
        
        BankAccount bank = new BankAccount(initialBalance);
        ThreadBankAccount account = new ThreadBankAccount(bank, withdrawAmount, depositAmount, rep);
        
        Thread r1 = new Thread(account);
        Thread r2 = new Thread(account);
        Thread r3 = new Thread(account);
        Thread r4 = new Thread(account);
        
        r1.setName("First User");
        r2.setName("Second User");
        r3.setName("Third User");
        r4.setName("Fourth User");
        
        r1.start();
        r2.start();
        r3.start();
        r4.start();
    }
}
