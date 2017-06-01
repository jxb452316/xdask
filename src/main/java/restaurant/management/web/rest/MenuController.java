package restaurant.management.web.rest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.management.model.Menu;
import restaurant.management.service.MenuService;

import java.util.List;

/**
 * Created by jiang (jiang.taojie@foxmail.com)
 * 2017/6/1 21:24 End.
 */
@RestController//@RestController+@ResponseBody
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /*void saveMenu(Menu menu);
    void updateMenu(Menu menu);
    Menu findOne(Long id);
    void deleteMenuById(Long id);
    List<Menu> findByDishname(String dishname);*/

    @PostMapping("saveMenu")// = @RequestMapping(value = "menu",method = RequestMethod.POST)
    public String saveMenu(Menu menu){
        menuService.saveMenu(menu);
        return "success";
    }

    @PostMapping("updateMenu")
    public String updateMenu(Menu menu){
        menuService.updateMenu(menu);
        return "success";
    }

    @PostMapping("deleteMenuById")
    public String deleteMenuById(Long id){
        menuService.deleteMenuById(id);
        return "success";
    }

    @PostMapping("findByDishname")
    public List<Menu> findByDishname(@RequestParam String dishname){
        return menuService.findByDishname(dishname);
    }

}
