package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.dao.ProjectDao;
import com.chalienko.hr.dao.impl.oracle.OracleDaoFactory;
import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.Employee;
import com.chalienko.hr.model.Manager;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.impl.real.RealProject;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chalienko on 01.02.2016.
 */
public class ProxyProject implements Project {
    private Long id;
    private RealProject project;

    public ProxyProject(Long id) {
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
    public List<Employee> getEmployees() {
        if (project == null){
            project = downloadProject();
        }
        return project.getEmployees();
    }

    @Override
    public void setEmployees(List<Employee> employees) {
        if (project == null){
            project = downloadProject();
        }
        project.setEmployees(employees);
    }

    @Override
    public Customer getCustomer() {
        if (project == null){
            project = downloadProject();
        }
        return project.getCustomer();
    }

    @Override
    public void setCustomer(Customer customer) {
        if (project == null){
            project = downloadProject();
        }
        project.setCustomer(customer);
    }

    @Override
    public Manager getManager() {
        if (project == null){
            project = downloadProject();
        }
        return project.getManager();
    }

    @Override
    public void setManager(Manager manager) {
        if (project == null){
            project = downloadProject();
        }
        project.setManager(manager);
    }

    @Override
    public String getProjectName() {
        if (project == null){
            project = downloadProject();
        }
        return project.getProjectName();
    }

    @Override
    public void setProjectName(String projectName) {
        if (project == null){
            project = downloadProject();
        }
        project.setProjectName(projectName);
    }

    private RealProject downloadProject(){
        RealProject project = null;
        try(OracleDaoFactory oracleDaoFactory = new OracleDaoFactory()) {
            ProjectDao projectDao = oracleDaoFactory.getProjectDao();
            project = (RealProject) projectDao.read(getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  project;
    }
}
