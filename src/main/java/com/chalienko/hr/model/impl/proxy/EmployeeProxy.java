package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.model.Employee;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.impl.real.CustomerImpl;
import com.chalienko.hr.model.impl.real.EmployeeImpl;
import com.chalienko.hr.service.CustomerService;
import com.chalienko.hr.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;

/**
 * Created by Chalienko on 01.02.2016.
 */
public class EmployeeProxy implements Employee {
    private Long id;
    private EmployeeImpl employee;

    public EmployeeProxy(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        if (employee == null) {
            employee = downloadEmployee();
        }
        return employee.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        if (employee == null) {
            employee = downloadEmployee();
        }
        employee.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        if (employee == null) {
            employee = downloadEmployee();
        }
        return employee.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        if (employee == null) {
            employee = downloadEmployee();
        }
        employee.setLastName(lastName);
    }

    @Override
    public void setProjects(List<Project> projects) {
        if (employee == null) {
            employee = downloadEmployee();
        }
        employee.setProjects(projects);
    }

    @Override
    public List<Project> getProjects() {
        if (employee == null) {
            employee = downloadEmployee();
        }
        return employee.getProjects();
    }

    private EmployeeImpl downloadEmployee() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        EmployeeService employeeService = (EmployeeService) appContext.getBean("employeeServiceImpl");
        return (EmployeeImpl) employeeService.getEmployee(getId());
    }

}
