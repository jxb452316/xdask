package restaurant.management.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.management.model.Customer;
import restaurant.management.model.Employee;
import restaurant.management.service.CustomerService;
import restaurant.management.service.EmployeeService;
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

}
