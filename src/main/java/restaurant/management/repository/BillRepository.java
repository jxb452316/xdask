package restaurant.management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Bill;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface BillRepository extends CrudRepository<Bill,Long> {
    List<Bill> findById(Long id);
    @Query("select a from bill a " +
            "where (?1 is null or a.id = ?1) " +
            "and (?2 is null or a.cusname like ?2) " +
            "and (?3 is null or a.date like ?3) " +
            "and (?4 is null or a.pmoney = ?4) ")
    List<Bill> filter(Long id, String cusname, String date, Double pmoney);
}
