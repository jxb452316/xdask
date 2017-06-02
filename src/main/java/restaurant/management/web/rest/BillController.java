package restaurant.management.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.management.model.Bill;
import restaurant.management.model.Customer;
import restaurant.management.model.Dbill;
import restaurant.management.service.BillService;
import restaurant.management.service.CustomerService;
import restaurant.management.service.DbillService;
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
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private DbillService dbillService;

    @RequestMapping(value = "search", method = { RequestMethod.POST, RequestMethod.GET })
    public List<Bill> search(@RequestParam(name = "billid", required = false, defaultValue = "") String billid,
                             @RequestParam(name = "cusname", required = false, defaultValue = "") String cusname,
                             @RequestParam(name = "date", required = false, defaultValue = "") String date,
                             @RequestParam(name = "pmoney", required = false, defaultValue = "") String pmoney)
                                 {
        return billService.filter(
                CommonUtils.nullIfEmpty(billid) == null ? null : Long.valueOf(billid),
                CommonUtils.nullIfEmpty(cusname),
                CommonUtils.nullIfEmpty(date) ,
                CommonUtils.nullIfEmpty(pmoney) == null ? null : Double.valueOf(pmoney)
        );
    }

    @RequestMapping(value = "details", method = { RequestMethod.POST, RequestMethod.GET })
    public List<Dbill> details(@RequestParam(name = "billid", required = true) Long billid) {
        return dbillService.findByBillid(billid);
    }

//    @RequestMapping(value = "save", method = { RequestMethod.POST })
//    public Bill save(@RequestBody Bill bill) {
//        billService.saveBill(bill);
//        return bill;
//    }
//
//    @RequestMapping(value = "update", method = { RequestMethod.POST })
//    public Bill update(@RequestBody Bill bill) {
//        billService.updateBill(bill);
//        return bill;
//    }
//
//    @RequestMapping(value = "delete/{id}", method = { RequestMethod.DELETE })
//    public OperationResponse delete(@PathVariable(name = "id") Long id) {
//        billService.deleteBillById(id);
//        OperationResponse response = new OperationResponse();
//        response.setSuccess(true);
//        return response;
//    }

    @RequestMapping(value = "save", method = { RequestMethod.POST })
    public Bill save(@RequestBody OrderRequest order) {
        if (order == null || order.getDbills() == null)
            throw new RuntimeException("点单不可为空");
        double totalPrice = 0;
        for (Dbill dbill: order.getDbills()) {
            totalPrice += dbill.getDishmoney() * dbill.getNumber();
        }
        Bill bill = new Bill(order.getCusname(), order.getDate(), totalPrice);
        billService.saveBill(bill);
        // 将生成的bill编号设置会dbill中，并存入数据库
        for (Dbill dbill: order.getDbills()) {
            dbill.setBillid(bill.getId());
            dbillService.saveDbill(dbill);
        }
        return bill;
    }
}
