package com.chalienko.hr.dao;

import com.chalienko.hr.model.Manager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 */

/**
 * The object for managing persistent state of the ManagerImpl object
 */
public interface ManagerDao {

    /**
     * It creates a new record and the corresponding object
     * @return ManagerImpl
     */
    void save(Manager manager);

    /**
     * Gets the appropriate entries to the primary by key or null
     * @param key
     * @return ManagerImpl
     */
    Manager getManagerById(Long key);

    /**
     * It saves the state of the object group in the database
     * @param manager
     */
    int update(Manager manager);

    /**
     * Removes the entry of the object from the database
     * @param manager
     */
    void delete(Manager manager);

    /**
     * Returns a list of all the relevant records in the database
     * @return List of Managers
     * @throws SQLException
     */
    List<Manager> getAll();
}
