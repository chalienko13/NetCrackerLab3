package com.chalienko.hr.model.impl.real;

import com.chalienko.hr.model.Employee;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.Model;

import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 *
 * ???????? 1-project and few realProjects
 */
public class EmployeeImpl implements Employee {

    private static final long serialVersionUID = -1724662175481476642L;

    private Long id;

    private String firstName;

    private String lastName;

    private List<Project> projects;

    public EmployeeImpl() {

    }

    public EmployeeImpl(Long id){
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "EmployeeImpl{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", projects=" + projects +
                '}';
    }
}
