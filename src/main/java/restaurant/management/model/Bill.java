package restaurant.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/5/21.
 */
@Entity(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // this is linked to the foreign key in Dbill (billid)
    private String cusname;
    private String date;
    private double pmoney;

    protected Bill() {
    }

    public Bill(String cusname, String date, double pmoney) {
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
