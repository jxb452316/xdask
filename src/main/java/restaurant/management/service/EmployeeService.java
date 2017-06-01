package restaurant.management.service;

import restaurant.management.model.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface EmployeeService {
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    Employee findOne(Long id);
    void deleteEmployeeById(Long id);
    List<Employee> findByEmname(String emname);
    List<Employee> filter(String emname, String emidcard, String emcellphone, Integer emage, Boolean emsex, String emaddress);
}
