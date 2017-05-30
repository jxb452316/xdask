package restaurant.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.management.model.Bill;
import restaurant.management.repository.BillRepository;
import restaurant.management.service.BillService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
@Service("billService")
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository repository;
    @Override
    @Transactional
    public void saveBill(Bill bill) {
        repository.save(bill);
    }

    @Override
    @Transactional
    public void updateBill(Bill bill) {
        repository.save(bill);
    }

    @Override
    @Transactional(readOnly = true)
    public Bill findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public void deleteBillById(Long id) {
        repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bill> findByBillnumber(String billnumber) {
        return repository.findByBillnumber(billnumber);
    }
}
