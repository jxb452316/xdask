package restaurant.management.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/5/27.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @RequestMapping(value = "/employeeOM", method = RequestMethod.GET)
    public String employeeOM() {
        return "employee/employeeOM";
    }

    @RequestMapping(value = "/employeeCR", method = RequestMethod.GET)
    public String employeeCR() {
        return "employee/employeeCR";
    }

    @RequestMapping(value = "/employeeMS", method = RequestMethod.GET)
    public String employeeMS() {
        return "employee/employeeMS";
    }

    @RequestMapping(value = "/employeeRc", method = RequestMethod.GET)
    public String employeeRc() {return "employee/employeeRc";}
}
