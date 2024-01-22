package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Customer {
    String name;
    Account account;

    Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }
}

class Account {
    int accountNumber;
    double balance;
    List<Transaction> transactions = new ArrayList<>();

    Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    void withdraw(double amount) {
        if(balance - amount < 0) {
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
    }

    void transfer(Account to, double amount) {
        withdraw(amount);
        to.deposit(amount);
    }
}

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class BankingApp {

    List<Customer> customers;

    public BankingApp() {
        customers = new ArrayList<>();

        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 2500);
        Account account3 = new Account(3, 500);
        Account account4 = new Account(4, 8000);
        Account account5 = new Account(5, 1200);
        Account account6 = new Account(6, 3000);
        Account account7 = new Account(7, 600);
        Account account8 = new Account(8, 4500);
        Account account9 = new Account(9, 1500);
        Account account10 = new Account(10, 7000);

        // Create customers
        Customer customer1 = new Customer("John", account1);
        Customer customer2 = new Customer("Alice", account2);
        Customer customer3 = new Customer("Bob", account3);
        Customer customer4 = new Customer("Eva", account4);
        Customer customer5 = new Customer("Michael", account5);
        Customer customer6 = new Customer("Sophie", account6);
        Customer customer7 = new Customer("Charlie", account7);
        Customer customer8 = new Customer("Olivia", account8);
        Customer customer9 = new Customer("Daniel", account9);
        Customer customer10 = new Customer("Emma", account10);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);
        customers.add(customer7);
        customers.add(customer8);
        customers.add(customer9);
        customers.add(customer10);
    }

    public static void main(String[] args) {
        BankingApp app = new BankingApp();
        app.run();
    }

    private void run() {
        int option;
        Scanner scanner = new Scanner(System.in);
        while(true) {

            System.out.println("Choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Print Transactions");
            System.out.println("6. Exit");

            option = scanner.nextInt();

                    switch(option) {
                        case 1:

                            break;

                        case 2:
                            // Call withdraw
                            break;

                        case 3:
                            // Call deposit
                            break;

                        case 4:
                            // Call transfer
                            break;

                        case 5:
                            // Call printTransactions
                            break;

                        case 6:
                            System.exit(0);

                        default:
                            System.out.println("Invalid option");
                    }
        }
    }

    // Get account by account number
    private Account getAccount(int accountNumber) {
        for(Customer c: customers) {
            if(c.account.accountNumber == accountNumber) {
                return c.account;
            }
        }
        return null;
    }

    void showBalance(int accountNumber) {
        Account account = getAccount(accountNumber);
        if(account == null) {
            System.out.println("Invalid account");
            return;
        }
        System.out.println(account.balance);
    }

    // Withdraw amount from account
    void withdraw(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if(account == null) {
            System.out.println("Invalid account");
            return;
        }

        account.withdraw(amount);
    }

    // Deposit amount to account
    void deposit(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if(account == null) {
            System.out.println("Invalid account");
            return;
        }

        account.deposit(amount);
    }

    // Transfer amount from one account to another
    void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        Account from = getAccount(fromAccountNumber);
        Account to = getAccount(toAccountNumber);

        if(from == null || to == null) {
            System.out.println("One or more invalid accounts");
            return;
        }

        from.transfer(to, amount);
    }

    // Print last 10 transactions of account
    void printTransactions(int accountNumber) {
        Account account = getAccount(accountNumber);
        if(account == null) {
            System.out.println("Invalid account");
            return;
        }

        List<Transaction> transactions = account.transactions;

        // Print last 10 transactions
        for(int i=Math.max(0, transactions.size()-10); i<transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.println(t.type + " " + t.amount);
        }
    }
}
