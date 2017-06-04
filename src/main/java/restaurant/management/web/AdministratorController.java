package restaurant.management.web;

/**
 * Created by Administrator on 2017/5/26.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
    @RequestMapping(value = "/adminEM", method = RequestMethod.GET)
    public String adminEE() {
        return "admin/adminEM";
    }

    @RequestMapping(value = "/adminMM", method = RequestMethod.GET)
    public String adminMM() {
        return "admin/adminMM";
    }

    @RequestMapping(value = "/adminCM", method = RequestMethod.GET)
    public String adminCM() {
        return "admin/adminCM";
    }

    @RequestMapping(value = "/adminMS", method = RequestMethod.GET)
    public String adminMS() {
        return "admin/adminMS";
    }

    @RequestMapping(value = "/adminSD", method = RequestMethod.GET)
    public String adminSD() {
        return "admin/adminSD";
    }

    @RequestMapping(value = "/adminSM", method = RequestMethod.GET)
    public String adminSM() {
        return "admin/adminSM";
    }

    @RequestMapping(value = "/adminSY", method = RequestMethod.GET)
    public String adminSY() {
        return "admin/adminSY";
    }

    @RequestMapping(value = "/adminDbill/{billId}", method = RequestMethod.GET)
    public String adminDbill(@PathVariable Long billId, Model model) {
        model.addAttribute("billId",billId);
        return "admin/adminDbill";
    }

}
