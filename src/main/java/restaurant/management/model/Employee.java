package restaurant.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Employee
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/5/20 - created by zhe.jiang
 */
@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String emname;
    private String emidcard;
    private String emcellphone;
    private int emage;
    private  boolean emsex;
    private  String emremark;
    private  String emaddress;
    protected  Employee(){}
    public Employee( String emname, String emidcard, String emcellphone, int emage, boolean emsex, String emremark, String emaddress) {

        this.emname = emname;
        this.emidcard = emidcard;
        this.emcellphone = emcellphone;
        this.emage = emage;
        this.emsex = emsex;
        this.emremark = emremark;
        this.emaddress = emaddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmname() {
        return emname;
    }

    public void setEmname(String emname) {
        this.emname = emname;
    }

    public String getEmidcard() {
        return emidcard;
    }

    public void setEmidcard(String emidcard) {
        this.emidcard = emidcard;
    }

    public String getEmcellphone() {
        return emcellphone;
    }

    public void setEmcellphone(String emcellphone) {
        this.emcellphone = emcellphone;
    }

    public int getEmage() {
        return emage;
    }

    public void setEmage(int emage) {
        this.emage = emage;
    }

    public boolean isEmsex() {
        return emsex;
    }

    public void setEmsex(boolean emsex) {
        this.emsex = emsex;
    }

    public String getEmremark() {
        return emremark;
    }

    public void setEmremark(String emremark) {
        this.emremark = emremark;
    }

    public String getEmaddress() {
        return emaddress;
    }

    public void setEmaddress(String emaddress) {
        this.emaddress = emaddress;
    }
}
