package restaurant.management.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @RequiresRoles({"admin"})
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @RequiresRoles({"employee"})
    public String employee() {
        return "employee/employee";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    @RequiresRoles({"customer"})
    public String customer() {
        return "customer/customer";
    }

    //下面两个是例子，理解后建议删掉
    @RequestMapping(value = "/addxxx", method = RequestMethod.GET)
    @RequiresRoles({"employee","admin"})
    public String employeeAddxxx() {
        return "employee/addxxx";
    }

    @RequestMapping(value = "/tablexxx", method = RequestMethod.GET)
    @RequiresRoles({"admin"})
    public String employeeTablexxx(Model model) {
        List<Administrator> administrators = new ArrayList<>();
        administrators.add(new Administrator("aa","11","13757182647",22,true,""));
        administrators.add(new Administrator("bb","11","13757182647",11,true,""));
        model.addAttribute("data",administrators);
        return "employee/tablexxx";
    }
}
