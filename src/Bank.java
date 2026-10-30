import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private int nextAccountNumber = 1001;

    public Account createSavings(String ownerName, double startingBalance) {
        Account account = new SavingsAccount(nextAccountNumber, ownerName, startingBalance, 2.5);
        accounts.add(account);
        nextAccountNumber++;
        return account;
    }

    public Account createChecking(String ownerName, double startingBalance) {
        Account account = new CheckingAccount(nextAccountNumber, ownerName, startingBalance, 100);
        accounts.add(account);
        nextAccountNumber++;
        return account;
    }

    public Account findAccount(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public void transfer(int fromNumber, int toNumber, double amount) throws InsufficientFundsException {
        Account from = findAccount(fromNumber);
        Account to = findAccount(toNumber);
        if (from == null || to == null) {
            throw new IllegalArgumentException("Account not found");
        }
        from.withdraw(amount);
        to.deposit(amount);
    }

    public void listAccounts() {
        if (accounts.size() == 0) {
            System.out.println("No accounts yet.");
            return;
        }
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }
    }
}
