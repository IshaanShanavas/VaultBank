public class Account {
    protected int accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(int accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be more than 0");
        }
        balance = balance + amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be more than 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough money in account");
        }
        balance = balance - amount;
    }

    public String getType() {
        return "Account";
    }

    public String toString() {
        return getType() + " #" + accountNumber + " | " + ownerName + " | balance: " + String.format("%.2f", balance);
    }
}
