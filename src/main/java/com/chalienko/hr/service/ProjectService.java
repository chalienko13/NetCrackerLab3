package com.chalienko.hr.service;

import com.chalienko.hr.dao.DaoFactory;
import com.chalienko.hr.dao.EmployeeDao;
import com.chalienko.hr.dao.ProjectDao;
import com.chalienko.hr.dao.impl.oracle.DaoOracleFactory;
import com.chalienko.hr.model.Project;

import java.sql.SQLException;

/**
 * Created by Chalienko on 08.02.2016.
 */
public class ProjectService {
    private ProjectDao projectDao;
    private EmployeeDao employeeDao;

    public void createProject(Project project) {
        try (DaoFactory daoFactory = new DaoOracleFactory()) {
            projectDao = daoFactory.getProjectDao();
            employeeDao = daoFactory.getEmployeeDao();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
