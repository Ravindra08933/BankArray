package com.ba.Service;
import com.ba.Exception.InsufficientFundsException;
import com.ba.bean.Account;
import com.ba.bean.Customer;
import com.ba.bean.Transaction;

import java.util.Collections;
import java.util.Date;
import java.util.List;
public class AccountServiceImpl {

    private List<Account> accounts;

    private List<Customer> customers;

    public void setCustomers(List<Customer> acc)
    {
        this.customers = acc;
    }
    public void setAccounts(List<Account> acc1)
    {
        this.accounts = acc1;
    }


    public double getBalance(Integer num) {
        Account account = findAccount(num);
        return account.getcurrentBalance();
    }

    public void withdraw(Account account, double amount) throws InsufficientFundsException {
        double balance = account.getcurrentBalance();
        if (balance >= amount) {
            account.setcurrentBalance(balance - amount);
            Transaction t = new Transaction(001, new Date(), -amount, "Withdraw");

        } else {
            throw new InsufficientFundsException();
        }
    }

    public void deposit(Account account, double amount) {
        double balance = account.getcurrentBalance();
        account.setcurrentBalance(balance + amount);
        Transaction t = new Transaction(002, new Date(), amount, "Deposit");

    }

    public void transfer(Account from, Account to, double amount) throws InsufficientFundsException {
        withdraw(from, amount);
        deposit(to, amount);
        Transaction t1 = new Transaction(003, new Date(), -amount, "Transfer to " + to.getAccountNumber());

        Transaction t2 = new Transaction(004, new Date(), amount, "Transfer from " + from.getAccountNumber());

    }

//    public List<Transaction> getRecentTransactions(Account account, int numTransactions) {
//        List<Transaction> allTransactions = account.getTransactions();
//        Collections.sort(allTransactions, (t1, t2) -> t2.getDate().compareTo(t1.getDate()));
//        return allTransactions.subList(0, numTransactions);
//    }
    public Account findAccount(int account)
    {
        System.out.println("Hello");
        for (Account accounts : accounts) {
            System.out.println(accounts);
            if(accounts.getAccountNumber()==account)
                return accounts;
        }
        return null;
    }

}
