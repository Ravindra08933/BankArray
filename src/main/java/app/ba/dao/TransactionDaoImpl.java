package app.ba.dao;
import app.ba.bean.Account;
import app.ba.bean.Transaction;
import app.ba.service.AccountServiceImpl;
public class TransactionDaoImpl implements TransactionDao
{
    @Override
    public Transaction[] getAllTransactions(int accountNumber) {
        Account account = new AccountDaoImpl().findAccountByNumber(accountNumber);
        if (account != null) {
            return account.getTransactions();
        } else {
            System.out.println("Invalid account number.");
            return null;
        }
    }
    @Override
    public Transaction[] getLast10Transactions(int accountNumber) {
        int j = -1;
        Transaction[] transactions1 = new Transaction[10];
        Account account = new AccountDaoImpl().findAccountByNumber(accountNumber);
        Transaction[] transactions = account.getTransactions();
        int index = new AccountServiceImpl().findAvailableTransactionIndex(transactions);
        if(index == -1)
        {
            for(int i = Math.max(0,transactions.length-10);i<transactions.length;i++)
            {
                j++;
                transactions1[j] = transactions[i];
            }
        }
        else
        {
            for(int i = 0;i<index;i++)
            {
                j++;
                transactions1[j] = transactions[i];
            }
        }
        return transactions1;
    }
}
