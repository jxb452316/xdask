package restaurant.management.service;

import restaurant.management.model.Dbill;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface DbillService {
    void saveDbill(Dbill dbill);
    void updateDbill(Dbill dbill);
    Dbill findOne(Long id);
    void deleteDbillById(Long id);
    List<Dbill> findByBillid(Long billid);
}
