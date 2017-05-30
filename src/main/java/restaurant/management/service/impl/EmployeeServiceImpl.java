package restaurant.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.management.model.Employee;
import restaurant.management.repository.EmployeeRepository;
import restaurant.management.service.EmployeeService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        repository.save(employee);

    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Long id) {
        repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findByEmname(String emname) {
        return repository.findByEmname(emname);
    }
}
