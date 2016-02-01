package com.chalienko.hr.model;

import java.util.List;

/**
 * Created by Chalienko on 01.02.2016.
 */
public interface Employee extends Model {
    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    void setProjects(List<Project> projects);

    List<Project> getProjects();
}
