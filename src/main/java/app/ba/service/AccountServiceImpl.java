package app.ba.service;
import app.ba.Exception.InvalidAccountException;
import app.ba.bean.Account;
import app.ba.bean.Customer;
import app.ba.bean.Transaction;
import app.ba.dao.AccountDaoImpl;
import app.ba.dao.TransactionDaoImpl;
import app.ba.util.BankUtil;
import java.time.LocalDate;
public class AccountServiceImpl implements AccountService {
    AccountDaoImpl accountDao = new AccountDaoImpl();
    TransactionDaoImpl transactionDao = new TransactionDaoImpl();

    @Override
    public double checkBalance(int accountNumber) throws InvalidAccountException
    {
        try
        {
            Account account = accountDao.findAccountByNumber(accountNumber);
            if (account != null)
            {
                return account.getCurrentBalance();
            }
            else
            {
                throw new InvalidAccountException("Account not found for account number: " + accountNumber);
            }
        }
        catch (InvalidAccountException e)
        {
            System.out.println("Error: " + e.getMessage());
            return 0.0;
        }
    }
    @Override
    public void deposit(int accountNumber, double amount) {
        if(amount<0)
        {
            System.out.println("Amount should be greater than 0");
        }
        else {
            try {
                Account account = accountDao.findAccountByNumber(accountNumber);
                if (account != null) {
                    double newBalance = account.getCurrentBalance() + amount;
                    account.setCurrentBalance(newBalance);
                    recordTransaction(account, "Deposit", amount);
                    System.out.println("Deposit successful. New balance: " + newBalance);
                } else {
                    throw new InvalidAccountException("Account not found for account number: " + accountNumber);
                }
            }
            catch (InvalidAccountException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    @Override
    public void withdraw(int accountNumber, double amount) {
        if(amount<0)
        {
            System.out.println("Amount should be greater than 0");
        }
        else {
            try {
                Account account = accountDao.findAccountByNumber(accountNumber);
                if (account != null) {
                    double currentBalance = account.getCurrentBalance();
                    if (currentBalance - amount >= 0) {
                        double newBalance = currentBalance - amount;
                        account.setCurrentBalance(newBalance);
                        recordTransaction(account, "Withdrawal", -amount);
                        System.out.println("Withdrawal successful. New balance: " + newBalance);
                    } else {
                        throw new InvalidAccountException("Account not found for account number: " + accountNumber);
                    }
                }
            } catch (InvalidAccountException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    @Override
    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        if(amount<0)
        {
            System.out.println("Amount should be greater than 0");
        }
        else {
            Account fromAccount = accountDao.findAccountByNumber(fromAccountNumber);
            Account toAccount = accountDao.findAccountByNumber(toAccountNumber);
            if (fromAccount != null && toAccount != null)
            {
                double fromBalance = fromAccount.getCurrentBalance();
                if (fromBalance - amount >= 0) {
                    double toBalance = toAccount.getCurrentBalance();
                    fromAccount.setCurrentBalance(fromBalance - amount);
                    toAccount.setCurrentBalance(toBalance + amount);
                    recordTransaction(fromAccount, "Transfer to " + toAccountNumber, -amount);
                    recordTransaction(toAccount, "Transfer from " + fromAccountNumber, amount);
                    System.out.println("Transfer successful.");
                }
                else
                {
                    System.out.println("Insufficient funds for transfer.");
                }
            }
            else
            {
                System.out.println("Invalid account numbers.");
            }
        }
    }

    public void recordTransaction(Account account, String description, double amount) {
        Transaction[] transactions = account.getTransactions();
        int index = findAvailableTransactionIndex(transactions);
        if(index == -1)
        {
            int s = transactions.length;
            int newSize = 2*transactions.length;
            Transaction[] newArray = new Transaction[newSize];
            System.arraycopy(transactions, 0, newArray, 0, transactions.length);
            transactions = newArray;
            index = s;
        }
        Transaction transaction = new Transaction(
                new BankUtil().generateAccountNumber(),
                LocalDate.now(),
                description,
                amount
        );
        transactions[index] = transaction;
    }
    public int findAvailableTransactionIndex(Transaction[] transactions) {
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void getLast10Transactions(int accNum)
    {
        Transaction[] transactions = transactionDao.getLast10Transactions(accNum);
        for(int i = 0;i<transactions.length;i++)
        {
            System.out.println(transactions[i]);
        }
    }
    @Override
    public Account createAccount(String name,String email,double amount) {
        Customer customer = new Customer(new BankUtil().generateAccountNumber(),name,email);
       return  accountDao.createAccount(customer);

    }
    @Override
    public void updateAccount(int accountNumber, String Name, String Email) {
        accountDao.updateAccount(accountNumber,Name,Email);
    }
    @Override
    public void deleteAccount(int accountNumber) {
        accountDao.deleteAccount(accountNumber);
    }
}
