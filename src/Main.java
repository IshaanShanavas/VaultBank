import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("=== Bank System ===");
            System.out.println("1. Create savings account");
            System.out.println("2. Create checking account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Add interest (savings)");
            System.out.println("7. List accounts");
            System.out.println("8. Quit");
            System.out.print("Choose: ");
            String choice = input.nextLine().trim();

            try {
                if (choice.equals("1") || choice.equals("2")) {
                    System.out.print("Owner name: ");
                    String name = input.nextLine().trim();
                    System.out.print("Starting balance: ");
                    double start = Double.parseDouble(input.nextLine().trim());
                    Account account;
                    if (choice.equals("1")) {
                        account = bank.createSavings(name, start);
                    } else {
                        account = bank.createChecking(name, start);
                    }
                    System.out.println("Created: " + account);
                } else if (choice.equals("3")) {
                    System.out.print("Account number: ");
                    int number = Integer.parseInt(input.nextLine().trim());
                    Account account = bank.findAccount(number);
                    if (account == null) {
                        System.out.println("Account not found.");
                    } else {
                        System.out.print("Amount: ");
                        double amount = Double.parseDouble(input.nextLine().trim());
                        account.deposit(amount);
                        System.out.println("New balance: " + account.getBalance());
                    }
                } else if (choice.equals("4")) {
                    System.out.print("Account number: ");
                    int number = Integer.parseInt(input.nextLine().trim());
                    Account account = bank.findAccount(number);
                    if (account == null) {
                        System.out.println("Account not found.");
                    } else {
                        System.out.print("Amount: ");
                        double amount = Double.parseDouble(input.nextLine().trim());
                        account.withdraw(amount);
                        System.out.println("New balance: " + account.getBalance());
                    }
                } else if (choice.equals("5")) {
                    System.out.print("From account: ");
                    int from = Integer.parseInt(input.nextLine().trim());
                    System.out.print("To account: ");
                    int to = Integer.parseInt(input.nextLine().trim());
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(input.nextLine().trim());
                    bank.transfer(from, to, amount);
                    System.out.println("Transfer complete.");
                } else if (choice.equals("6")) {
                    System.out.print("Account number: ");
                    int number = Integer.parseInt(input.nextLine().trim());
                    Account account = bank.findAccount(number);
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).addInterest();
                        System.out.println("New balance: " + account.getBalance());
                    } else {
                        System.out.println("Not a savings account.");
                    }
                } else if (choice.equals("7")) {
                    bank.listAccounts();
                } else if (choice.equals("8")) {
                    running = false;
                    System.out.println("Bye!");
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        input.close();
    }
}
