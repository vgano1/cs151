
public class BankAccount {
    private int currentBal;
    
    public BankAccount(int currentBal) {
        this.currentBal = currentBal;
    }
    
    public void setBalance(int currentBal) {
        this.currentBal = currentBal;
    }
    
    public int getBalance() {
        return currentBal;
    }
    
    public void withdrawMoney(int money) {
        currentBal -= money;
    }
    public void depositMoney(int money) {
        currentBal += money;
    }
}
