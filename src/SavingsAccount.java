public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance = balance + interest;
    }

    public String getType() {
        return "Savings";
    }
}
