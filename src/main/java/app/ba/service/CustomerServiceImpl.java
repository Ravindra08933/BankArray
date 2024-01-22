package app.ba.service;
import app.ba.bean.Customer;
import app.ba.util.BankUtil;
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer createCustomer(String name, String email) {
        Customer customer = new Customer(new BankUtil().generateAccountNumber(),name,email);
        return customer;
    }
}
