package restaurant.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.management.model.Customer;
import restaurant.management.repository.CustomerRepository;
import restaurant.management.service.CustomerService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository repository;


    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findByCusname(String cusname) {
        return repository.findByCusname(cusname);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> filter(String cusname, String cusidcard, String cuscellphone, double money) {
        return repository.filter(cusname, cusidcard, cuscellphone,money);}
}