package restaurant.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/5/21.
 */
@Entity(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dishname;
    private double dishmoney;

    protected  Menu(){}

    public Menu( String dishname, double dishmoney) {
        this.dishname = dishname;
        this.dishmoney = dishmoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
