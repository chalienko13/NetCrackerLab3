package com.chalienko.hr.model;

/**
 * Created by Chalienko on 09-Dec-15.
 */
public class Manager extends Model {

    private static final long serialVersionUID = 9105111485873801110L;

    private String firstName;

    private String lastName;

    private Project project;

    public Manager() {
        super();
    }

    public Manager(Long id){
        super(id);
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

}
