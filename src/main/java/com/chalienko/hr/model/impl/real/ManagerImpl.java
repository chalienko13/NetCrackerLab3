package com.chalienko.hr.model.impl.real;

import com.chalienko.hr.model.Manager;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.Model;

/**
 * Created by Chalienko on 09-Dec-15.
 */
public class ManagerImpl implements Manager {

    private static final long serialVersionUID = 9105111485873801110L;

    private Long id;

    private String firstName;

    private String lastName;

    private Project project;

    public ManagerImpl() {

    }

    public ManagerImpl(Long id){
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    @Override
    public String toString() {
        return "ManagerImpl{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", realProject='" +  project.getProjectName() + '\'' +
                '}';
    }


}
