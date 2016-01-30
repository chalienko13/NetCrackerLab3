package com.chalienko.hr.dao.impl.oracle;

import com.chalienko.hr.dao.ManagerDao;
import com.chalienko.hr.model.Employee;
import com.chalienko.hr.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chalienko on 29.01.2016.
 */
public class OracleManagerDao implements ManagerDao {
    private Connection connection;

    public OracleManagerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Manager create() {
        return null;
    }

    @Override
    public Manager read(Long key) throws SQLException {
        String sql = "SELECT * FROM C##CHAL.MANAGER WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,key);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        Manager manager = new Manager();
        manager.setId(rs.getLong("ID"));
        manager.setFirstName(rs.getString("FIRST_NAME"));
        manager.setLastName(rs.getString("LAST_NAME"));
        return manager;
    }

    @Override
    public int update(Manager manager) throws SQLException {
        String sql = "UPDATE C##CHAL.MANAGER SET FIRST_NAME = ?, LAST_NAME = ?  WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,manager.getFirstName());
        preparedStatement.setString(2,manager.getLastName());
        preparedStatement.setLong(3, manager.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Manager manager) throws SQLException {
        String sql = "DELETE FROM C##CHAL.MANAGER WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,manager.getId());
        preparedStatement.execute();
    }

    @Override
    public List<Manager> getAll() throws SQLException {
        String sql = "SELECT * FROM C##CHAL.MANAGER";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<Manager> list = new ArrayList<>();
        while (rs.next()){
            Manager manager = new Manager();
            manager.setId(rs.getLong("ID"));
            manager.setFirstName(rs.getString("FIRST_NAME"));
            manager.setLastName(rs.getString("LAST_NAME"));
            list.add(manager);
        }
        return list;
    }
}
