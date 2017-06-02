package restaurant.management.web.rest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.management.common.Constant;
import restaurant.management.common.ResultDto;
import restaurant.management.model.Menu;
import restaurant.management.service.MenuService;

import java.util.List;

@RestController
@RequestMapping(value = "api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @RequestMapping( value = "search" , method = { RequestMethod.POST, RequestMethod.GET })
    public List<Menu> search(@RequestParam String dishname){
        return menuService.filter(dishname);
    }

    @PostMapping("save")// = @RequestMapping(value = "menu",method = RequestMethod.POST)
    public Menu saveMenu(@RequestBody Menu menu){
        menuService.saveMenu(menu);
        return menu;
    }

    @PostMapping("update")
    public Menu  updateMenu(@RequestBody Menu menu){
        menuService.updateMenu(menu);
        return menu;
    }

    @PostMapping("delete/{id}")
    public OperationResponse  deleteMenuById(@PathVariable Long id){
        menuService.deleteMenuById(id);
        OperationResponse response = new OperationResponse();
        response.setSuccess(true);
        return response;
    }

}
