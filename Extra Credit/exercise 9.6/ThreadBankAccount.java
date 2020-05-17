
public class ThreadBankAccount implements Runnable{
    
    private BankAccount account;
    private int withdrawalAmount;
    private int depositAmount;
    private int repetitions;
    
    public ThreadBankAccount(BankAccount account, int withdrawalAmount, int depositAmount, int repetitions) {
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
        this.depositAmount = depositAmount;
        this.repetitions = repetitions;
    }
    
    
    @Override
    public void run() {
        for (int i=0; i<repetitions; i++) {
            makeAWithdrawal(withdrawalAmount);
            if(account.getBalance()<0) {
                System.out.println("Overdraft!");
            }
            makeADeposit(depositAmount);
        }
    }
    
    private synchronized void makeAWithdrawal(int amount) {
        if(account.getBalance()>=amount) {
            System.out.println(Thread.currentThread().getName()+ " is going to withdraw $" + amount);
            try {
                Thread.sleep(100);
                
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            account.withdrawMoney(amount);
            System.out.println("Thank you " + Thread.currentThread().getName() + ", your withdrawal transaction is complete! Your balance is $" + account.getBalance());
        }
        else {
            System.out.println("Not enough money in the account for " + Thread.currentThread().getName() + " to withdraw $" + amount + ". Current Balance: $" + account.getBalance());
        }
    }
    
    private synchronized void makeADeposit(int amount) {
        if(amount>0) {
            System.out.println(Thread.currentThread().getName()+ " is going to deposit $" + amount);
            try {
                Thread.sleep(100);
                
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            account.depositMoney(amount);
            System.out.println("Thank you " + Thread.currentThread().getName() + ", your deposit transaction is complete! Your balance is $" + account.getBalance());
        }
        else {
            System.out.println("Not enough money for " + Thread.currentThread().getName() + " to deposit. Current Balance: $" + account.getBalance());
        }
    }
    
}
