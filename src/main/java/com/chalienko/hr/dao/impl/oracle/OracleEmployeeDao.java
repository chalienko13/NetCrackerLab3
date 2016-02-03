package com.chalienko.hr.dao.impl.oracle;

import com.chalienko.hr.dao.EmployeeDao;
import com.chalienko.hr.model.Employee;
import com.chalienko.hr.model.impl.real.EmployeeImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chalienko on 29.01.2016.
 */
public class OracleEmployeeDao implements EmployeeDao {
    private Connection connection;

    public OracleEmployeeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Employee create() {
        return null;
    }

    @Override
    public Employee read(Long key) throws SQLException {
        String sql = "SELECT * FROM C##CHAL.EMPLOYEE WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,key);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        Employee employee = new EmployeeImpl();
        employee.setId(rs.getLong("ID"));
        employee.setFirstName(rs.getString("FIRST_NAME"));
        employee.setLastName(rs.getString("LAST_NAME"));
        return employee;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        String sql = "UPDATE C##CHAL.EMPLOYEE SET FIRST_NAME = ?, LAST_NAME = ?  WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,employee.getFirstName());
        preparedStatement.setString(2,employee.getLastName());
        preparedStatement.setLong(3, employee.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        String sql = "DELETE FROM C##CHAL.EMPLOYEE WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,employee.getId());
        preparedStatement.execute();
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        String sql = "SELECT * FROM C##CHAL.EMPLOYEE";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<Employee> list = new ArrayList<>();
        while (rs.next()){
            Employee employee = new EmployeeImpl();
            employee.setId(rs.getLong("ID"));
            employee.setFirstName(rs.getString("FIRST_NAME"));
            employee.setLastName(rs.getString("LAST_NAME"));
            list.add(employee);
        }
        return list;
    }
}
