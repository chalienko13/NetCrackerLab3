package com.chalienko.hr.dao;

import com.chalienko.hr.model.Manager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 */

/**
 * The object for managing persistent state of the Manager object
 */
public interface ManagerDao {

    /**
     * It creates a new record and the corresponding object
     * @return Manager
     */
    Manager create();

    /**
     * Gets the appropriate entries to the primary by key or null
     * @param key
     * @return Manager
     */
    Manager read(Long key) throws SQLException;

    /**
     * It saves the state of the object group in the database
     * @param manager
     */
    int update(Manager manager) throws SQLException;

    /**
     * Removes the entry of the object from the database
     * @param manager
     */
    void delete(Manager manager) throws SQLException;

    /**
     * Returns a list of all the relevant records in the database
     * @return List of Managers
     * @throws SQLException
     */
    List<Manager> getAll() throws SQLException;
}
