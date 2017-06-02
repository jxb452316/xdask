package restaurant.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.management.model.Menu;
import restaurant.management.repository.MenuRepository;
import restaurant.management.service.MenuService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
@Service("MenuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository repository;

    @Override
    @Transactional
    public void saveMenu(Menu menu) {
        repository.save(menu);

    }

    @Override
    @Transactional
    public void updateMenu(Menu menu) {
        repository.save(menu);
    }

    @Override
    @Transactional(readOnly = true)
    public Menu findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public void deleteMenuById(Long id) {
        repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> findByDishname(String dishname) {
        return repository.findByDishname(dishname);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Menu> filter(String dishname, String dishmoney) {
        return repository.filter(dishname, dishmoney);}
}
