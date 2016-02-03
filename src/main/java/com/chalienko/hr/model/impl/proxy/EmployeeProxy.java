package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.dao.EmployeeDao;
import com.chalienko.hr.dao.impl.oracle.OracleDaoFactory;
import com.chalienko.hr.model.Employee;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.impl.real.EmployeeImpl;


import java.sql.SQLException;
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
        if(employee == null){
            employee = (EmployeeImpl) downloadEmployee();
        }
        return employee.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        if(employee == null){
            employee = downloadEmployee();
        }
        employee.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        if(employee == null){
            employee = (EmployeeImpl) downloadEmployee();
        }
        return employee.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        if(employee == null){
            employee = (EmployeeImpl) downloadEmployee();
        }
        employee.setLastName(lastName);
    }

    @Override
    public void setProjects(List<Project> projects) {
        if(employee == null){
            employee = (EmployeeImpl) downloadEmployee();
        }
        employee.setProjects(projects);
    }

    @Override
    public List<Project> getProjects() {
        if(employee == null){
            employee = (EmployeeImpl) downloadEmployee();
        }
        return employee.getProjects();
    }

    private EmployeeImpl downloadEmployee(){
        EmployeeImpl employee = null;
        try(OracleDaoFactory oracleDaoFactory = new OracleDaoFactory()) {
            EmployeeDao employeeDao = oracleDaoFactory.getEmployeeDao();
            employee = (EmployeeImpl) employeeDao.read(getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  employee;
    }
}
