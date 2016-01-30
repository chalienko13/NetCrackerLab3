package com.chalienko.hr.model;

import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 */
public class Project extends Model {

    private static final long serialVersionUID = -5809112583788445522L;

    private Customer customer;

    private Manager manager;

    private String projectName;

    private List<Employee> employees;

    public Project() {
        super();
    }

    public Project(Long id) {
        super(id);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
