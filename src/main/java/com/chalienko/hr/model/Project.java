package com.chalienko.hr.model;

import java.util.List;

/**
 * Created by Chalienko on 01.02.2016.
 */
public interface Project  extends Model {
    List<Employee> getEmployees();

    void setEmployees(List<Employee> employees);

    Customer getCustomer();

    void setCustomer(Customer customer);

    Manager getManager();

    void setManager(Manager manager);

    String getProjectName();

    void setProjectName(String projectName);
}
