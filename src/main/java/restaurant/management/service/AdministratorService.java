package restaurant.management.service;

import restaurant.management.model.Administrator;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface AdministratorService {
    void saveAdministrator(Administrator administrator);
    void updateAdministrator(Administrator administrator);
    Administrator findOne(Long id);
    void deleteAdministratorById(Long id);
    List<Administrator> findByAdname(String adname);

}
