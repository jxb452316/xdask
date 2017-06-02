package restaurant.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Customer
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/5/20 - created by zhe.jiang
 */
@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cusname;
    private String cusidcard;
    private String cuscellphone;
    private double money;
    protected Customer(){}
    public Customer( String cusname, String cusidcard, String cuscellphone, double money) {
        this.cusname = cusname;
        this.cusidcard = cusidcard;
        this.cuscellphone = cuscellphone;
        this.money = money;
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

    public String getCusidcard() {
        return cusidcard;
    }

    public void setCusidcard(String cusidcard) {
        this.cusidcard = cusidcard;
    }

    public String getCuscellphone() {
        return cuscellphone;
    }

    public void setCuscellphone(String cuscellphone) {
        this.cuscellphone = cuscellphone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }




}
