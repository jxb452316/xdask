package restaurant.management.service;

import restaurant.management.model.Bill;
import restaurant.management.model.TotalBill;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface BillService {
    void saveBill(Bill bill);
    void updateBill(Bill bill);
    Bill findOne(Long id);
    void deleteBillById(Long id);
    List<Bill> filter(Long billid, String cusname, String date, Double pmoney);

    List<TotalBill> groupByYear();

    List<TotalBill> groupByMonth();

    List<TotalBill> groupByDay();
}
