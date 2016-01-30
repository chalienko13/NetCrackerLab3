package com.chalienko.hr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 *
 * ???????? 1-project and few projects
 */
public class Employee extends Model {

    private static final long serialVersionUID = -1724662175481476642L;

    private String firstName;

    private String lastName;

    private List<Project> projects;

    public Employee() {
        super();
    }

    public Employee(Long id){
        super(id);
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
}
