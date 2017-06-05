package restaurant.management.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.management.model.Customer;
import restaurant.management.model.UserLogin;
import restaurant.management.service.CustomerService;
import restaurant.management.service.UserLoginService;
import restaurant.management.utils.CommonUtils;

import java.util.List;

/**
 * EmployeeRestController
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/6/1 - created by zhe.jiang
 */
@RestController
@RequestMapping("api/customer")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "search", method = { RequestMethod.POST, RequestMethod.GET })
    public List<Customer> search(@RequestParam(name = "cusname", required = false, defaultValue = "") String cusname,
                                 @RequestParam(name = "cusidcard", required = false, defaultValue = "") String cusidcard,
                                 @RequestParam(name = "cuscellphone", required = false, defaultValue = "") String cuscellphone,
                                 @RequestParam(name = "money", required = false, defaultValue = "") String money)
                                 {
        return customerService.filter(
                CommonUtils.nullIfEmpty(cusname),
                CommonUtils.nullIfEmpty(cusidcard),
                CommonUtils.nullIfEmpty(cuscellphone),
                CommonUtils.nullIfEmpty(money) == null ? null : Double.valueOf(money)
        );
    }

    @RequestMapping(value = "save", method = { RequestMethod.POST })
    public Customer save(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        userLoginService.saveLogin(
                new UserLogin(customer.getCusname(),"",UserLogin.USER_TYPE_CUSTOMER));

        return customer;
    }

    @RequestMapping(value = "update", method = { RequestMethod.POST })
    public Customer update(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return customer;
    }

    @RequestMapping(value = "delete/{id}", method = { RequestMethod.DELETE })
    public OperationResponse delete(@PathVariable(name = "id") Long id) {
        customerService.deleteCustomerById(id);
        OperationResponse response = new OperationResponse();
        response.setSuccess(true);
        return response;
    }

    @RequestMapping(value = "addAmount", method = { RequestMethod.POST })
    public OperationResponse addAmount(@RequestParam(name = "cusname", required = false, defaultValue = "") String cusname,
                                       @RequestParam(name = "amount", required = false, defaultValue = "0") Double amount) {
        OperationResponse response = new OperationResponse();
        List<Customer> customers = customerService.findByCusname(cusname);
        if (customers.size() == 0) {
            response.setSuccess(false);
            response.setMessage("用户不存在");
            return response;
        }
        Customer customer = customers.get(0);
        Double temp = customer.getMoney() + amount;
        customer.setMoney(temp);
        customerService.saveCustomer(customer);
        response.setSuccess(true);
        response.setMessage("当前余额为"+customer.getMoney()+"元");
        return response;
    }

}
