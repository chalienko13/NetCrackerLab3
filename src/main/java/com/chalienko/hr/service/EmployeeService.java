package com.chalienko.hr.service;

import com.chalienko.hr.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chalienko on 11.02.2016.
 */
@Service
public interface EmployeeService {

    Employee getEmployee(Long id);

    void saveEmployee(Employee employee);

    int updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    List<Employee> getEmployees();
}
