package app.ba.service;
import app.ba.Exception.InvalidAccountException;
import app.ba.bean.Account;
import app.ba.bean.Transaction;

import java.util.List;
public interface AccountService {
    double checkBalance(int accountNumber) throws InvalidAccountException;
    void deposit(int accountNumber, double amount);
    void withdraw(int accountNumber, double amount);
    void transfer(int fromAccountNumber, int toAccountNumber, double amount);
    void getLast10Transactions(int accNum);
    Account createAccount(String name, String email,double amount);
    void updateAccount(int accountNumber,String Name,String Email);
    void deleteAccount(int accountNumber);

}
