package com.chalienko.hr;

import com.chalienko.hr.dao.ProjectDao;
import com.chalienko.hr.dao.impl.oracle.DaoOracleFactory;
import com.chalienko.hr.model.Project;

import java.sql.SQLException;

/**
 * Created by Chalienko on 06-Dec-15.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Project project = null;
        try(DaoOracleFactory daoOracleFactory = new DaoOracleFactory()){
            ProjectDao projectDao = daoOracleFactory.getProjectDao();
            project = projectDao.read(1L);
        } catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(project);

    }
}
