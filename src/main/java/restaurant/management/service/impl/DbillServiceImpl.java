package restaurant.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.management.model.Dbill;
import restaurant.management.repository.DbillRepository;
import restaurant.management.service.DbillService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
@Service("dbillService")
public class DbillServiceImpl implements DbillService {
    @Autowired
    private DbillRepository repository;
    @Override
    @Transactional
    public void saveDbill(Dbill Dbill) {
        repository.save(Dbill);
    }

    @Override
    @Transactional
    public void updateDbill(Dbill Dbill) {
        repository.save(Dbill);
    }

    @Override
    @Transactional(readOnly = true)
    public Dbill findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public void deleteDbillById(Long id) {
        repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dbill> findByBillnumber(String billnumber) {return repository.findByBillnumber(billnumber);
    }


}
