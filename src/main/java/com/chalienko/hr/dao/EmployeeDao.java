package com.chalienko.hr.dao;

import com.chalienko.hr.model.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 */
/**
 * The object for managing persistent state of the EmployeeImpl object
 */
public interface EmployeeDao {

    /**
     * It creates a new record and the corresponding object
     * @return EmployeeImpl
     */
    void save(Employee employee);

    /**
     * Gets the appropriate entries to the primary by key or null
     * @param key
     * @return EmployeeImpl
     */
    Employee getEmployeeById(Long key);

    /**
     * It saves the state of the object group in the database
     * @param employee
     */
    int update(Employee employee);

    /**
     * Removes the entry of the object from the database
     * @param employee
     */
    void delete(Employee employee);

    /**
     * Returns a list of all the relevant records in the database
     * @return List of Employees
     * @throws SQLException
     */
    List<Employee> getAll();
}
