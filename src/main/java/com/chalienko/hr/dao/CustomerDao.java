package com.chalienko.hr.dao;

/**
 * Created by Chalienko on 09-Dec-15.
 */

import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.impl.real.RealCustomer;

import java.sql.SQLException;
import java.util.List;

/**
 * The object for managing persistent state of the RealCustomer object
 */
public interface CustomerDao {

    /**
     * It creates a new record and the corresponding object
     * @return RealCustomer
     */
    Customer create();

    /**
     * Gets the appropriate entries to the primary by key or null
     * @param key
     * @return RealCustomer
     */
    Customer read(Long key) throws SQLException;

    /**
     * It saves the state of the object group in the database
     * @param customer
     */
    int update(Customer customer) throws SQLException;

    /**
     * Removes the entry of the object from the database
     * @param customer
     */
    void delete(Customer customer) throws SQLException;

    /**
     * Returns a list of all the relevant records in the database
     * @return List of Customs
     * @throws SQLException
     */
    List<Customer> getAll() throws SQLException;
}
