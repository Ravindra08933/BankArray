package app.ba.dao;
import app.ba.bean.Account;
import app.ba.bean.Customer;
public interface AccountDao {
    Account findAccountByNumber(int accountNumber);
    Account findAccountByCustomerId(int customerId);
    Account[] getAllAccounts();
    Account createAccount(Customer customer);
    void deleteAccount(int accountNumber);
    void updateAccount(int accNum,String name,String email);
}
