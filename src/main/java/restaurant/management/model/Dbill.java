package restaurant.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/5/21.
 */
@Entity(name = "dbill")
public class Dbill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long billid;
    private String dishname;
    private double dishmoney;
    private int number;
    protected Dbill(){}


    public Dbill(Long billid, String dishname, double dishmoney, int number) {
        this.billid = billid;
        this.dishname = dishname;
        this.dishmoney = dishmoney;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillid() {
        return billid;
    }

    public void setBillid(Long billid) {
        this.billid = billid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public double getDishmoney() {
        return dishmoney;
    }

    public void setDishmoney(double dishmoney) {
        this.dishmoney = dishmoney;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
