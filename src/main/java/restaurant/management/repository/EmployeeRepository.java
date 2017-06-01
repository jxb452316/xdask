package restaurant.management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import restaurant.management.model.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    List<Employee> findByEmname(String emname);
    @Query("select a from employee a " +
            "where (?1 is null or a.emname like ?1) " +
            "and (?2 is null or a.emidcard like ?2) " +
            "and (?3 is null or a.emcellphone like ?3) " +
            "and (?4 is null or a.emage = ?4) " +
            "and (?5 is null or a.emsex = ?5) " +
            "and (?6 is null or a.emaddress like ?6)")
    List<Employee> filter(String emname, String emidcard, String emcellphone, Integer emage, Boolean emsex, String emaddress);

}
