package com.chalienko.hr.dao;

import com.chalienko.hr.model.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 */
/**
 * The object for managing persistent state of the Employee object
 */
public interface EmployeeDao {

    /**
     * It creates a new record and the corresponding object
     * @return Employee
     */
    Employee create();

    /**
     * Gets the appropriate entries to the primary by key or null
     * @param key
     * @return Employee
     */
    Employee read(Long key) throws SQLException;

    /**
     * It saves the state of the object group in the database
     * @param employee
     */
    int update(Employee employee) throws SQLException;

    /**
     * Removes the entry of the object from the database
     * @param employee
     */
    void delete(Employee employee) throws SQLException;

    /**
     * Returns a list of all the relevant records in the database
     * @return List of Employees
     * @throws SQLException
     */
    List<Employee> getAll() throws SQLException;
}
