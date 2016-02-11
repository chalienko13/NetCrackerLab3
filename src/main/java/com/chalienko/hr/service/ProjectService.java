package com.chalienko.hr.service;

import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.Project;

import java.util.List;

/**
 * Created by Chalienko on 11.02.2016.
 */
public interface ProjectService {

    Project getProject(Long id);

    void saveProject(Project project);

    int updateProject(Project project);

    void deleteProject(Project project);

    List<Project> getProjects();
}
