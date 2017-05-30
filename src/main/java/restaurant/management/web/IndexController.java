package restaurant.management.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
