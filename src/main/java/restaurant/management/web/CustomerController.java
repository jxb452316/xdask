package restaurant.management.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/5/27.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @RequestMapping(value = "/customerMS", method = RequestMethod.GET)
    public String customerMS() {
        return "customer/customerMS";
    }

    @RequestMapping(value = "/customerDbill/{billId}", method = RequestMethod.GET)
    public String customerDbil(@PathVariable Long billId, Model model) {
        model.addAttribute("billId",billId);
        return "customer/customerDbill";
    }

}
