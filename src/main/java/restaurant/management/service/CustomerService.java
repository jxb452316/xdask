package restaurant.management.service;

import restaurant.management.model.Customer;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface CustomerService {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer findOne(Long id);
    void deleteCustomerById(Long id);
    List<Customer> findByCusname(String cusname);
}
