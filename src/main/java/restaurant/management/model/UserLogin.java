package restaurant.management.model;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * UserLogin
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/5/20 - created by zhe.jiang
 */
@Entity(name = "user_login")
@Table(name = "user_login")
public class UserLogin {
    public static final int USER_TYPE_UNKNOWN = 0;
    public static final int USER_TYPE_ADMINISTRATOR = 1;
    public static final int USER_TYPE_EMPLOYEE = 2;
    public static final int USER_TYPE_CUSTOMER = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private int usertype;

    protected UserLogin() {}

    public UserLogin(String username, String password, int usertype) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "UserLogin{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
