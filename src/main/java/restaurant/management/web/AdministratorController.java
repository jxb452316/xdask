package restaurant.management.web;

/**
 * Created by Administrator on 2017/5/26.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
    @RequestMapping(value = "/adminEM", method = RequestMethod.GET)
    public String adminEE() {
        return "adminEM";
    }

    @RequestMapping(value = "/adminMM", method = RequestMethod.GET)
    public String adminMM() {
        return "adminMM";
    }

}
