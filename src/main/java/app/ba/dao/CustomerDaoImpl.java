package app.ba.dao;
import app.ba.bean.Customer;
import app.ba.util.BankUtil;
public class CustomerDaoImpl implements CustomerDao{
    @Override
    public Customer findCustomerById(int customerId) {
        for (Customer customer : BankUtil.getCustomers()) {
            if (customer != null && customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }
    @Override
    public Customer findCustomerByName(String Name) {
        for (Customer customer : BankUtil.getCustomers()) {
            if (customer != null && customer.getName() == Name) {
                return customer;
            }
        }
        return null;
    }


}
