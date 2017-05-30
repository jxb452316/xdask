package restaurant.management.repository;

import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.UserLogin;

import java.util.List;

/**
 * UserLoginRepository
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/5/20 - created by zhe.jiang
 */
public interface UserLoginRepository extends CrudRepository<UserLogin, Long> {

    List<UserLogin> findByUsername(String username);
}
