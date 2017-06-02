package restaurant.management.web.rest;

import restaurant.management.model.Dbill;

import java.util.List;

/**
 * OrderRequest
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/6/2 - created by zhe.jiang
 */
public class OrderRequest {
    private String cusname;
    private String date;
    private List<Dbill> dbills;

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Dbill> getDbills() {
        return dbills;
    }

    public void setDbills(List<Dbill> dbills) {
        this.dbills = dbills;
    }
}
