package restaurant.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.management.model.UserLogin;
import restaurant.management.repository.UserLoginRepository;
import restaurant.management.service.UserLoginService;

import java.util.List;

/**
 * UserLoginServiceImpl
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/5/20 - created by zhe.jiang
 */
@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginRepository repository;

    @Override
    @Transactional
    public void saveLogin(UserLogin login) {
        repository.save(login);
    }

    @Override
    @Transactional
    public void updateLogin(UserLogin login) {
        repository.save(login);
    }

    @Override
    @Transactional(readOnly = true)
    public UserLogin findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserLogin> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly=true)
    public UserLogin authenticate(String username, String password) {
        List<UserLogin> logins = repository.findByUsername(username);
        if (logins.isEmpty())
            return null;
        for (UserLogin login: logins) {
            if (login.getPassword().equals(password)) {
                return login;
            }
        }
        return null;
    }

}
