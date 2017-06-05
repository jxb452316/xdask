package restaurant.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import restaurant.management.model.TotalBill;

import java.util.List;

/**
 * TotalBillRepository
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/6/5 - created by zhe.jiang
 */
public interface TotalBillRepository extends JpaRepository<TotalBill, Long> {
    @Query(nativeQuery = true)
    List<TotalBill> groupByYear();

    @Query(nativeQuery = true)
    List<TotalBill> groupByMonth();

    @Query(nativeQuery = true)
    List<TotalBill> groupByDay();

}
