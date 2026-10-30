public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int accountNumber, String ownerName, double balance, double overdraftLimit) {
        super(accountNumber, ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // checking accounts can go below 0 up to the overdraft limit
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be more than 0");
        }
        if (amount > balance + overdraftLimit) {
            throw new InsufficientFundsException("Overdraft limit of " + overdraftLimit + " exceeded");
        }
        balance = balance - amount;
    }

    public String getType() {
        return "Checking";
    }
}
