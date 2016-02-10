package com.chalienko.hr.dao.impl.oracle;

import com.chalienko.hr.dao.DAOException;
import com.chalienko.hr.dao.DaoFactory;
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
public class EmployeeOracleDao implements EmployeeDao {

    private DaoFactory daoFactory = new DaoOracleFactory();

    @Override
    public void create(Employee employee) throws DAOException {
        String sql = "INSERT INTO EMPLOYEE(ID, FIRST_NAME, LAST_NAME) VALUES(?,?,?))";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException("Cannot create employee", e);
        }
    }

    @Override
    public Employee read(Long key) throws DAOException {
        String sql = "SELECT * FROM C##CHAL.EMPLOYEE WHERE ID = ?";
        Employee employee = null;

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            statement.setLong(1, key);
            if (rs.next()) {
                employee = new EmployeeImpl();
                employee.setId(rs.getLong("ID"));
                employee.setFirstName(rs.getString("FIRST_NAME"));
                employee.setLastName(rs.getString("LAST_NAME"));
            }
            return employee;
        } catch (SQLException e) {
            throw new DAOException("Cannot read Employee", e);
        }
    }

    @Override
    public int update(Employee employee) throws DAOException {
        String sql = "UPDATE C##CHAL.EMPLOYEE SET FIRST_NAME = ?, LAST_NAME = ?  WHERE ID = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setLong(3, employee.getId());
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Cannot update employee", e);
        }
    }

    @Override
    public void delete(Employee employee) throws DAOException {
        String sql = "DELETE FROM C##CHAL.EMPLOYEE WHERE ID = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, employee.getId());
            statement.execute();

        } catch (SQLException e) {
            throw new DAOException("Cannot delete employee", e);
        }
    }

    @Override
    public List<Employee> getAll() throws DAOException {
        String sql = "SELECT * FROM C##CHAL.EMPLOYEE";
        List<Employee> list = new ArrayList<>();

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Employee employee = new EmployeeImpl();
                employee.setId(rs.getLong("ID"));
                employee.setFirstName(rs.getString("FIRST_NAME"));
                employee.setLastName(rs.getString("LAST_NAME"));
                list.add(employee);
            }
            return list;

        } catch (SQLException e) {
            throw new DAOException("Cannot get all employee", e);
        }
    }
}
