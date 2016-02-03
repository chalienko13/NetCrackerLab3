package com.chalienko.hr.dao.impl.oracle;

import com.chalienko.hr.dao.CustomerDao;
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
public class OracleCustomerDao implements CustomerDao {
    private Connection connection;

    public OracleCustomerDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public Customer create() {
        return null;
    }

    @Override
    public Customer read(Long key) throws SQLException {
        String sql = "SELECT * FROM C##CHAL.CUSTOMER WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,key);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        Customer customer = new CustomerImpl();
        customer.setId(rs.getLong("ID"));
        customer.setCustomerName(rs.getString("NAME"));
        return customer;
    }

    @Override
    public int update(Customer customer) throws SQLException {
        String sql = "UPDATE C##CHAL.CUSTOMER SET NAME = ? WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,customer.getCustomerName());
        preparedStatement.setLong(2,customer.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Customer customer) throws SQLException {
        String sql = "DELETE FROM C##CHAL.CUSTOMER WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,customer.getId());
        preparedStatement.execute();
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        String sql = "SELECT * FROM C##CHAL.CUSTOMER";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<Customer> list = new ArrayList<>();
        while (rs.next()){
            Customer customer = new CustomerImpl();
            customer.setId(rs.getLong("ID"));
            customer.setCustomerName(rs.getString("NAME"));
            list.add(customer);
        }
        return list;
    }
}
