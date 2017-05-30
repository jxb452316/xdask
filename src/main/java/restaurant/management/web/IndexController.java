package restaurant.management.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import restaurant.management.model.Administrator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhe.jiang on 2017/5/22.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/forbidden", method = RequestMethod.GET)
    public String forbidden() {
        return "forbidden";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            return "redirect:login";
        }
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.hasRole("admin")) {
            return "redirect:forbidden";
        }
        return "admin";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employee() {
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.hasRole("employee")) {
            return "redirect:forbidden";
        }
        return "employee";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String customer() {
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.hasRole("customer")) {
            return "redirect:forbidden";
        }
        return "customer";
    }

    @RequestMapping(value = "/addxxx", method = RequestMethod.GET)
    public String employeeAddxxx() {
        return "employee/addxxx";
    }

    @RequestMapping(value = "/tablexxx", method = RequestMethod.GET)
    public String employeeTablexxx(Model model) {
        List<Administrator> administrators = new ArrayList<>();
        administrators.add(new Administrator("aa","11","13757182647",22,true,""));
        administrators.add(new Administrator("bb","11","13757182647",11,true,""));
        model.addAttribute("data",administrators);
        return "employee/tablexxx";
    }
}
