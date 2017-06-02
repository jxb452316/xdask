package restaurant.management.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.management.model.Bill;
import restaurant.management.model.Customer;
import restaurant.management.service.BillService;
import restaurant.management.service.CustomerService;
import restaurant.management.utils.CommonUtils;

import java.sql.Date;
import java.util.List;

/**
 * EmployeeRestController
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/6/1 - created by zhe.jiang
 */
@RestController
@RequestMapping("api/bill")
public class billController {

    @Autowired
    private BillService billService;

    @RequestMapping(value = "search", method = { RequestMethod.POST, RequestMethod.GET })
    public List<Bill> search(@RequestParam(name = "billnumber", required = false, defaultValue = "") String billnumber,
                             @RequestParam(name = "cusname", required = false, defaultValue = "") String cusname,
                             @RequestParam(name = "date", required = false, defaultValue = "") String date,
                             @RequestParam(name = "pmoney", required = false, defaultValue = "") String pmoney)
                                 {
        return billService.filter(
                CommonUtils.nullIfEmpty(billnumber),
                CommonUtils.nullIfEmpty(cusname),
                CommonUtils.nullIfEmpty(date) ,
                CommonUtils.nullIfEmpty(pmoney) == null ? null : Double.valueOf(pmoney)

        );
    }

    @RequestMapping(value = "save", method = { RequestMethod.POST })
    public Bill save(@RequestBody Bill bill) {
        billService.saveBill(bill);
        return bill;
    }

    @RequestMapping(value = "update", method = { RequestMethod.POST })
    public Bill update(@RequestBody Bill bill) {
        billService.updateBill(bill);
        return bill;
    }

    @RequestMapping(value = "delete/{id}", method = { RequestMethod.DELETE })
    public OperationResponse delete(@PathVariable(name = "id") Long id) {
        billService.deleteBillById(id);
        OperationResponse response = new OperationResponse();
        response.setSuccess(true);
        return response;
    }

}
