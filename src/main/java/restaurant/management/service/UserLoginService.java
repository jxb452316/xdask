package restaurant.management.service;

import restaurant.management.model.UserLogin;

import java.util.List;

/**
 * UserLoginService
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/5/20 - created by zhe.jiang
 */
public interface UserLoginService {

    /**
     * save the login
     * @param login
     */
    void saveLogin(UserLogin login);

    /**
     * update the login
     * @param login
     */
    void updateLogin(UserLogin login);

    /**
     * find one login with primary key
     * @param id
     * @return
     */
    UserLogin findOne(Long id);

    /**
     * delete the login
     * @param id
     */
    void deleteUserById(Long id);

    List<UserLogin> findByUsername(String username);

    /**
     * authenticate the user with login provided, and
     * return the user type if authentication succeeds,
     * otherwise returns UserLogin.USER_TYPE_UNKNOWN
     * @param username
     * @param password
     * @return
     */
    UserLogin authenticate(String username, String password);
}
