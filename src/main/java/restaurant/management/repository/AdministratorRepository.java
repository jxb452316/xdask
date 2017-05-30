package restaurant.management.repository;

import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Administrator;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
    List<Administrator> findByAdname(String adname);

}
