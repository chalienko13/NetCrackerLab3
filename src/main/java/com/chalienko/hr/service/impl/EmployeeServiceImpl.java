package com.chalienko.hr.service.impl;

import com.chalienko.hr.dao.EmployeeDao;
import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.Employee;
import com.chalienko.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chalienko on 11.02.2016.
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getEmployee(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getAll();
    }
}
