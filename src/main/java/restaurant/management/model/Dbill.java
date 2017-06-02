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
    private String billnumber;
    private String dishname;
    private double dishmoney;
    private int number;
    protected Dbill(){}


    public Dbill(String billnumber, String dishname, double dishmoney, int number) {
        this.billnumber = billnumber;
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

    public String getBillnumber() {
        return billnumber;
    }

    public void setBillnumber(String billnumber) {
        this.billnumber = billnumber;
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
