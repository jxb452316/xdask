package restaurant.management.repository;

import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Bill;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface BillRepository extends CrudRepository<Bill,Long> {
    List<Bill> findByBillnumber(String billnumber);
}
