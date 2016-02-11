package com.chalienko.hr.service.impl;

import com.chalienko.hr.dao.ProjectDao;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Created by Chalienko on 11.02.2016.
 */
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Override
    public Project getProject(Long id) {
        return projectDao.getProjectByID(id);
    }

    @Override
    public void saveProject(Project project) {
        projectDao.save(project);
    }

    @Override
    public int updateProject(Project project) {
        return projectDao.update(project);
    }

    @Override
    public void deleteProject(Project project) {
        projectDao.delete(project);
    }

    @Override
    public List<Project> getProjects() {
        return projectDao.getAll();
    }
}
