package restaurant.management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Dbill;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface DbillRepository extends CrudRepository<Dbill,Long> {
    List<Dbill> findByBillid(Long billid);

}
