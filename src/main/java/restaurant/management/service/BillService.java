package restaurant.management.service;

import restaurant.management.model.Bill;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface BillService {
    void saveBill(Bill bill);
    void updateBill(Bill bill);
    Bill findOne(Long id);
    void deleteBillById(Long id);
    List<Bill> findByBillnumber(String billnumber);
    List<Bill> filter(String billnumber, String cusname, String date, double pmoney);
}
