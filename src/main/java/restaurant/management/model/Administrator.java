package restaurant.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Administrator
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/5/20 - created by zhe.jiang
 */
@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String adname;
    private String idcard;
    private String adcellphone;
    private int adage;
    private boolean adsex;
    private String adremark;

    protected Administrator() {
    }

    public Administrator(String adname, String idcard, String adcellphone, int adage, boolean adsex, String adremark) {

        this.adname = adname;
        this.idcard = idcard;
        this.adcellphone = adcellphone;
        this.adage = adage;
        this.adsex = adsex;
        this.adremark = adremark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAdcellphone() {
        return adcellphone;
    }

    public void setAdcellphone(String adcellphone) {
        this.adcellphone = adcellphone;
    }

    public int getAdage() {
        return adage;
    }

    public void setAdage(int adage) {
        this.adage = adage;
    }

    public boolean isAdsex() {
        return adsex;
    }

    public void setAdsex(boolean adsex) {
        this.adsex = adsex;
    }

    public String getAdremark() {
        return adremark;
    }

    public void setAdremark(String adremark) {
        this.adremark = adremark;
    }
}
