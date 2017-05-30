package restaurant.management.repository;

import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    List<Employee> findByEmname(String emname);
}
