package com.ba.util;
import com.ba.Service.AccountService;
import com.ba.bean.Account;
import com.ba.bean.Customer;
import com.ba.bean.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BankUtil
{
   static  int size = 10;
    public static Customer[] customers = new Customer[size];
    static Account[] accounts = new Account[size];
    static Transaction[] transactions = new Transaction[size];


static
{

    accounts[0] = new Account(1, 1000, "Current");
    accounts[1] = new Account(2, 2000, "Current");
    accounts[2] = new Account(3, 3000, "Current");
    customers[0] = new Customer("AB", 101, accounts[0]);
    customers[1] = new Customer("CD", 102, accounts[1]);
    customers[2] = new Customer("EF", 103, accounts[2]);
    transactions[0] = new Transaction(210,new Date("2022-12-12"),1234,"Deposit");
    transactions[1] = new Transaction(211,new Date("2023-12-12"),1000,"Deposit");
    transactions[2] = new Transaction(212,new Date("2022-12-12"),4000,"Deposit");
}


    public void addCustomer(String name,Integer id,Account account)
    {
        int index = findEmptyIndex(customers);
        if(index == -1)
        {
            Customer[] newCustomers = new Customer[2*customers.length];
            System.arraycopy(customers, 0, newCustomers, 0, customers.length);
            customers = newCustomers;
            index = findEmptyIndex(customers);
            customers[index] = new Customer(name,id,account);
        }
        else
        {
            customers[index] = new Customer(name,id,account);
        }
    }
    public Customer deleteCustomer(Integer cid)
    {
        int index = findCustomerById(cid);
        if (index != -1)
        {
            Account customerAccount = customers[index].getAccount();
            if (customerAccount != null)
            {
                customers[index].setAccount(null);
            }
            customers[index] = null;
            System.out.println("Customer with ID " + cid + " deleted successfully.");
        }
        else
        {
            System.out.println("Customer with ID " + cid + " not found.");
        }
        return findCustomerIndexById(cid);
    }

    private Customer findCustomerIndexById(Integer cid)
    {
        for (int i = 0; i < customers.length; i++)
        {
            if (customers[i] != null && customers[i].getId().equals(cid))
            {
                return customers[i];
            }
        }
        return null;
    }
    private int findCustomerById(Integer cid)
    {
        for (int i = 0; i < customers.length; i++)
        {
            if (customers[i] != null && customers[i].getId().equals(cid))
            {
                return i;
            }
        }
        return -1;
    }
    public int findEmptyIndex(Customer[] customers)
    {
        for(int i = 0;i<customers.length;i++)
        {
            if(customers[i] == null)
                return i;
        }
        return -1;
    }

    public void printCustomerDetailsByAccountNumber(int accountNumber)
    {
        Customer customer = findCustomerByAccountNumber(accountNumber);
        if (customer != null)
        {
            System.out.println("Customer Details for Account Number " + accountNumber + ":");
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Account Type: " + customer.getAccount().getAccountNumber());
            System.out.println("Account Balance: " + customer.getAccount().getcurrentBalance());
        }
        else
        {
            System.out.println("Customer with Account Number " + accountNumber + " not found.");
        }
    }

    private Customer findCustomerByAccountNumber(int accountNumber)
    {
        for (Customer customer : customers)
        {
            if (customer != null && customer.getAccount().getAccountNumber() == accountNumber)
            {
                return customer;
            }
        }
        return null;
    }
}