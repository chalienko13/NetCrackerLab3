package com.chalienko.hr.dao.impl.oracle;

import com.chalienko.hr.dao.ProjectDao;
import com.chalienko.hr.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chalienko on 29.01.2016.
 */
public class OracleProjectDao implements ProjectDao {
    private Connection connection;

    public OracleProjectDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Project create() {
        return null;
    }

    @Override
    public Project read(Long key) throws SQLException {
        String sql = "SELECT * FROM C##CHAL.PROJECT WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,key);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        Project project = new Project();
        project.setId(rs.getLong("ID"));
        project.setProjectName(rs.getString("PROJECT_NAME"));
        return project;
    }

    @Override
    public int update(Project project) throws SQLException {
        String sql = "UPDATE C##CHAL.Project SET PROJECT_NAME = ?  WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,project.getProjectName());
        preparedStatement.setLong(2, project.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Project project) throws SQLException {
        String sql = "DELETE FROM C##CHAL.Project WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,project.getId());
        preparedStatement.execute();
    }

    @Override
    public List<Project> getAll() throws SQLException {
        String sql = "SELECT * FROM C##CHAL.Project";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<Project> list = new ArrayList<>();
        while (rs.next()){
            Project project = new Project();
            project.setId(rs.getLong("ID"));
            project.setProjectName(rs.getString("PROJECT_NAME"));
            list.add(project);
        }
        return list;
    }
}
