package com.chalienko.hr.model.impl.real;

import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.Employee;
import com.chalienko.hr.model.Manager;
import com.chalienko.hr.model.Project;

import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 */
public class RealProject implements Project {

    private static final long serialVersionUID = -5809112583788445522L;

    private Long id;

    private Customer customer;

    private Manager manager;

    private String projectName;

    private List<Employee> employees;

    public RealProject() {
    }

    public RealProject(Long id) {
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

    @Override
    public String toString() {
        return "RealProject{" +
                "id=" + id +
                ", customer=" + customer.getCustomerName() +
                ", manager=" + manager.getLastName() +
                ", projectName='" + projectName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
