package restaurant.management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Menu;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface MenuRepository extends CrudRepository<Menu,Long> {
    List<Menu> findByDishname(String dishname);
    @Query("select a from menu a " +
            "where (?1 is null or a.dishname like ?1) " +
            "and (?2 is null or a.dishmoney like ?2) " )
    List<Menu> filter(String dishname, String dishmoney);
}
