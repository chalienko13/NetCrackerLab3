package com.chalienko.hr.model;

/**
 * Created by Chalienko on 01.02.2016.
 */
public interface Manager extends Model {

    Project getProject();

    void setProject(Project project);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);
}
