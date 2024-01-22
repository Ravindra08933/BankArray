package app.ba.util;
import app.ba.bean.Account;
import app.ba.bean.Customer;
import java.util.Random;
public class BankUtil {
    static int size = 10;
    public static Customer[] customers = new Customer[size];
    public static Account[] accounts = new Account[size];
    static {
        customers[0] = new Customer(1001, "James","James@gmail.com");
        customers[1] = new Customer(1002, "Parley","parley@hotmail.com");
        customers[2] = new Customer(1003, "Steve","steve@outlook.com");
        accounts[0] = new Account(121, 500, "Savings", customers[0]);
        accounts[1] = new Account(122, 500, "Savings", customers[1]);
        accounts[2] = new Account(123, 500, "Current", customers[2]);
    }

    public static void createAccount(int accountNumber, double initialBalance, String accountType, Customer customer)
    {
        int customerIndex = findAvailableCustomerIndex();
        customers[customerIndex]= customer;
        if (customer != null)
        {
            int accountIndex = findAvailableAccountIndex();
            if (accountIndex == -1)
            {
                resizeAccountsArray();
                accountIndex = findAvailableAccountIndex();
            }
            Account newAccount = new Account(accountNumber, initialBalance, accountType, customer);
            accounts[accountIndex] = newAccount;
            System.out.println("Account created successfully!");
        }
    }

    public static void deleteAccount(int accountNumber)
    {
        int accountIndex = findAccountIndexByNumber(accountNumber);
        if (accountIndex != -1)
        {
            accounts[accountIndex] = null;
            System.out.println("Account with number " + accountNumber + " deleted successfully!");
        }
        else
        {
            System.out.println("Account with number " + accountNumber + " not found.");
        }
    }
    private static int findAccountIndexByNumber(int accountNumber)
    {
        for (int i = 0; i < size; i++)
        {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber)
            {
                return i;
            }
        }
        return -1;
    }
    private static void resizeAccountsArray()
    {
        int newSize = size * 2;
        Account[] newAccounts = new Account[newSize];
        System.arraycopy(accounts, 0, newAccounts, 0, size);
        accounts = newAccounts;
        size = newSize;
    }

    private static int findAvailableAccountIndex() {
        for (int i = 0; i < size; i++) {
            if (accounts[i] == null) {
                return i;
            }
        }
        return -1;
    }
    private static int findAvailableCustomerIndex() {
        for (int i = 0; i < size; i++) {
            if (customers[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private static Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer != null && customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public static Customer[] getCustomers() {
        return customers;
    }

    private final int ACCOUNT_NUMBER_LENGTH = 8;

    private final Random random = new Random();

    public  int generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            accountNumber.append(random.nextInt(10));
        }

        return Integer.parseInt(accountNumber.toString());
    }

}
