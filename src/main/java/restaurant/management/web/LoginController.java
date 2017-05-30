package restaurant.management.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import restaurant.management.model.UserLogin;
/**
 * Created by zhe.jiang on 2017/5/22.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@RequestParam(name = "username") String username,
                              @RequestParam(name = "password") String password) {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(new UsernamePasswordToken(username, password));
        UserLogin login = (UserLogin)currentUser.getPrincipal();
        switch (login.getUsertype()) {
            case UserLogin.USER_TYPE_ADMINISTRATOR:
                return "redirect:admin";
            case UserLogin.USER_TYPE_EMPLOYEE:
                return "redirect:employee";
            case UserLogin.USER_TYPE_CUSTOMER:
                return "redirect:customer";
            default:
                return "redirect:forbidden";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
        }
        return "redirect:login";
    }

}
