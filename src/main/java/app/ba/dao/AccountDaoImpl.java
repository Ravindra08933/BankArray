package app.ba.dao;
import app.ba.Exception.InvalidAccountException;
import app.ba.bean.Account;
import app.ba.bean.Customer;
import app.ba.util.BankUtil;

import static app.ba.util.BankUtil.accounts;
public class AccountDaoImpl implements AccountDao {

    BankUtil bankUtil = new BankUtil();
    @Override
    public Account findAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account != null && account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
    @Override
    public Account findAccountByCustomerId(int customerId) {
        for (Account account : accounts) {
            if (account != null && account.getCustomer().getCustomerId() == customerId) {
                return account;
            }
        }
        return null;
    }
    @Override
    public Account[] getAllAccounts() {
        return accounts;
    }
    @Override
    public Account createAccount(Customer customer) {
        int accNum = bankUtil.generateAccountNumber();
        BankUtil.createAccount(accNum,500,"Savings", customer);
        return findAccountByNumber(accNum);

    }
    @Override
    public void deleteAccount(int accountNumber) {
        for (int i = 0;i<accounts.length;i++)
        {
            if(accounts[i].getAccountNumber()==accountNumber)
            {
                accounts[i] = null;
            }
        }
    }
    @Override
    public void updateAccount(int accNum, String name, String email) {
        Customer customer = findAccountByNumber(accNum).getCustomer();
        customer.setName(name);
        customer.setEmail(email);
    }
}
