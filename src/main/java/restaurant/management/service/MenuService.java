package restaurant.management.service;

import restaurant.management.model.Menu;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface MenuService {
    void saveMenu(Menu menu);
    void updateMenu(Menu menu);
    Menu findOne(Long id);
    void deleteMenuById(Long id);
    List<Menu> findByDishname(String dishname);
    List<Menu> filter(String dishname, String dishmoney);
}
