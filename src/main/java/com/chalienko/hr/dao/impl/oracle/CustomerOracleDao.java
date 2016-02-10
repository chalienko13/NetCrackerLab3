package com.chalienko.hr.dao.impl.oracle;

import com.chalienko.hr.dao.CustomerDao;
import com.chalienko.hr.dao.DAOException;
import com.chalienko.hr.dao.DaoFactory;
import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.impl.real.CustomerImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chalienko on 10-Dec-15.
 */
public class CustomerOracleDao implements CustomerDao {

    private DaoFactory daoFactory = new DaoOracleFactory();

    @Override
    public void create(Customer customer) throws DAOException {
        String sql = "INSERT INTO CUSTOMER(ID, NAME) VALUES(?,?))";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, customer.getId());
            statement.setString(2, customer.getCustomerName());
            statement.execute();

        } catch (SQLException e) {
            throw new DAOException("Cannot create customer", e);
        }
    }

    @Override
    public Customer getByID(Long key) throws DAOException {
        String sql = "SELECT * FROM C##CHAL.CUSTOMER WHERE ID = ?";
        Customer customer = null;

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            statement.setLong(1, key);
            if (rs.next()) {
                customer = new CustomerImpl();
                customer.setId(rs.getLong("ID"));
                customer.setCustomerName(rs.getString("NAME"));
            }

        } catch (SQLException e) {
            throw new DAOException("Cannot read customer by id", e);
        }
        return customer;
    }

    @Override
    public int update(Customer customer) throws DAOException {
        String sql = "UPDATE C##CHAL.CUSTOMER SET NAME = ? WHERE ID = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getCustomerName());
            statement.setLong(2, customer.getId());
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Cannot update customer", e);
        }
    }

    @Override
    public void delete(Customer customer) throws DAOException {
        String sql = "DELETE FROM C##CHAL.CUSTOMER WHERE ID = ?";

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, customer.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAll() throws DAOException {
        String sql = "SELECT * FROM C##CHAL.CUSTOMER";
        List<Customer> list = new ArrayList<>();

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Customer customer = new CustomerImpl();
                customer.setId(rs.getLong("ID"));
                customer.setCustomerName(rs.getString("NAME"));
                list.add(customer);
            }
            return list;

        } catch (SQLException e) {
            throw new DAOException("Cannot get all Customers", e);
        }
    }
}
