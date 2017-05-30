package restaurant.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/5/21.
 */
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String billnumber;
    private String cusname;
    private String date;
    private double pmoney;

    protected Bill() {
    }

    public Bill( String billnumber, String cusname, String date, double pmoney) {

        this.billnumber = billnumber;
        this.cusname = cusname;
        this.date = date;
        this.pmoney = pmoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillnumber() {
        return billnumber;
    }

    public void setBillnumber(String billnumber) {
        this.billnumber = billnumber;
    }

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

    public double getPmoney() {
        return pmoney;
    }

    public void setPmoney(double pmoney) {
        this.pmoney = pmoney;
    }
}
