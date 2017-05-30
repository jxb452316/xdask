package restaurant.management.repository;

import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Menu;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface MenuRepository extends CrudRepository<Menu,Long> {
    List<Menu> findByDishname(String dishname);
}
