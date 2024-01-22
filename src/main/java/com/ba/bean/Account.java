package com.ba.bean;
import java.util.List;
public class Account {
    private int accountNumber;
    private double currentBalance;
    private String accountType;

    public Account(int accountNumber, double currentBalance,String accType) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.accountType = accType;

    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public double getcurrentBalance() {
        return currentBalance;
    }
    public void setcurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Account() {
    }
}


