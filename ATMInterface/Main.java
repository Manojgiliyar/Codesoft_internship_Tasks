import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("\n===== ATM Menu =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("=====================");
    }

    public void run() {
        System.out.println("Welcome to the ATM!");

        while (true) {
            this.displayOptions();
            System.out.print("Enter your choice (1/2/3/4): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter the amount to withdraw: ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (this.bankAccount.withdraw(amount)) {
                    System.out.println("Withdrawal successful. Please take your cash.");
                } else {
                    System.out.println("Insufficient balance or invalid amount. Please try again.");
                }

            } else if (choice.equals("2")) {
                System.out.print("Enter the amount to deposit: ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (this.bankAccount.deposit(amount)) {
                    System.out.println("Deposit successful. Thank you for banking with us.");
                } else {
                    System.out.println("Invalid amount. Please try again.");
                }

            } else if (choice.equals("3")) {
                double balance = this.bankAccount.checkBalance();
                System.out.println("Your account balance is: $" + balance);

            } else if (choice.equals("4")) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a bank account object and an ATM object
        BankAccount bankAccount = new BankAccount(1000); // You can set the initial balance as required
        ATM atm = new ATM(bankAccount);

        // Run the ATM
        atm.run();
    }
}
