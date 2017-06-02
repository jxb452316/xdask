package restaurant.management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Customer;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByCusname(String cusname);
    @Query("select a from customer a " +
            "where (?1 is null or a.cusname like ?1) " +
            "and (?2 is null or a.cusidcard like ?2) " +
            "and (?3 is null or a.cuscellphone like ?3) " +
            "and (?4 is null or a.money = ?4) ")

    List<Customer> filter(String cusname, String cusidcard, String cuscellphone, Double money);
}
