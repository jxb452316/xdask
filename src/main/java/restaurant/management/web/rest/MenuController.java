package restaurant.management.web.rest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.management.common.Constant;
import restaurant.management.common.ResultDto;
import restaurant.management.model.Menu;
import restaurant.management.service.MenuService;

import java.util.List;

/**
 * Created by jiang (jiang.taojie@foxmail.com)
 * 2017/6/1 21:24 End.
 */
@RestController//@Controller+@ResponseBody
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("saveMenu")// = @RequestMapping(value = "menu",method = RequestMethod.POST)
    public ResultDto<Object> saveMenu(Menu menu){
        menuService.saveMenu(menu);
        return new ResultDto<>();
    }

    @PostMapping("updateMenu")
    public ResultDto<Object>  updateMenu(Menu menu){
        menuService.updateMenu(menu);
        return new ResultDto<>();
    }

    @PostMapping("deleteMenuById")
    public ResultDto<Object>  deleteMenuById(Long id){
        menuService.deleteMenuById(id);
        return new ResultDto<>();
    }

    @PostMapping("findByDishname")
    public ResultDto<List<Menu>> findByDishname(@RequestParam String dishname){
        return new ResultDto<>(Constant.SUCCESS,menuService.findByDishname(dishname));
    }

}
