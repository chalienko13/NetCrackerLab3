package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.dao.EmployeeDao;
import com.chalienko.hr.dao.impl.oracle.OracleDaoFactory;
import com.chalienko.hr.model.Employee;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.impl.real.RealEmployee;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chalienko on 01.02.2016.
 */
public class ProxyEmployee implements Employee {
    private Long id;
    private RealEmployee employee;

    public ProxyEmployee(Long id) {
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
            employee = (RealEmployee) downloadEmployee();
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
            employee = (RealEmployee) downloadEmployee();
        }
        return employee.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        if(employee == null){
            employee = (RealEmployee) downloadEmployee();
        }
        employee.setLastName(lastName);
    }

    @Override
    public void setProjects(List<Project> projects) {
        if(employee == null){
            employee = (RealEmployee) downloadEmployee();
        }
        employee.setProjects(projects);
    }

    @Override
    public List<Project> getProjects() {
        if(employee == null){
            employee = (RealEmployee) downloadEmployee();
        }
        return employee.getProjects();
    }

    private RealEmployee downloadEmployee(){
        RealEmployee employee = null;
        try(OracleDaoFactory oracleDaoFactory = new OracleDaoFactory()) {
            EmployeeDao employeeDao = oracleDaoFactory.getEmployeeDao();
            employee = (RealEmployee) employeeDao.read(getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  employee;
    }
}
