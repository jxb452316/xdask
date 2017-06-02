package restaurant.management.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.management.model.Employee;
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
@RequestMapping("api/employee")
public class CustomerRestController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "search", method = { RequestMethod.POST, RequestMethod.GET })
    public List<Employee> search(@RequestParam(name = "emname", required = false, defaultValue = "") String emname,
                                 @RequestParam(name = "emidcard", required = false, defaultValue = "") String emidcard,
                                 @RequestParam(name = "emcellphone", required = false, defaultValue = "") String emcellphone,
                                 @RequestParam(name = "emage", required = false, defaultValue = "") String emage,
                                 @RequestParam(name = "emsex", required = false, defaultValue = "") String emsex,
                                 @RequestParam(name = "emaddress", required = false, defaultValue = "") String emaddress) {
        return employeeService.filter(
                CommonUtils.nullIfEmpty(emname),
                CommonUtils.nullIfEmpty(emidcard),
                CommonUtils.nullIfEmpty(emcellphone),
                CommonUtils.nullIfEmpty(emage) == null ? null : Integer.valueOf(emage),
                CommonUtils.nullIfEmpty(emsex) == null ? null : Boolean.valueOf(emsex),
                CommonUtils.nullIfEmpty(emaddress)
        );
    }

    @RequestMapping(value = "save", method = { RequestMethod.POST })
    public Employee save(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @RequestMapping(value = "update", method = { RequestMethod.POST })
    public Employee update(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return employee;
    }

    @RequestMapping(value = "delete/{id}", method = { RequestMethod.DELETE })
    public OperationResponse delete(@PathVariable(name = "id") Long id) {
        employeeService.deleteEmployeeById(id);
        OperationResponse response = new OperationResponse();
        response.setSuccess(true);
        return response;
    }

}
