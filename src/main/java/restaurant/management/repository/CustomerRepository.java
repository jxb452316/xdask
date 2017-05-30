package restaurant.management.repository;

import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Customer;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByCusname(String cusname);
}
