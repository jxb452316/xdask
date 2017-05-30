package restaurant.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.management.model.Administrator;
import restaurant.management.repository.AdministratorRepository;
import restaurant.management.service.AdministratorService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
@Service("adminitratorService")
public class AdministratorServiceImpl implements AdministratorService {


        @Autowired
    private AdministratorRepository repository;


        @Override
        @Transactional
        public void saveAdministrator(Administrator administrator) {
            repository.save(administrator);
        }

        @Override
        @Transactional
        public void updateAdministrator(Administrator administrator) {
            repository.save(administrator);
        }

        @Override
        @Transactional(readOnly = true)
       public Administrator findOne(Long id) {
        return repository.findOne(id);

    }

        @Override
        @Transactional
        public void deleteAdministratorById(Long id) {
            repository.delete(id);
        }

        @Override
        @Transactional(readOnly = true)
        public List<Administrator> findByAdname(String adname) {
            return repository.findByAdname(adname);
        }


}
