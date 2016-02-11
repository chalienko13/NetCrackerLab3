package com.chalienko.hr.dao;

/**
 * Created by Chalienko on 09-Dec-15.
 */

import com.chalienko.hr.model.Project;

import java.sql.SQLException;
import java.util.List;

/**
 * The object for managing persistent state of the ProjectImpl object
 */
public interface ProjectDao {
    /**
     * It creates a new record and the corresponding object
     * @return ProjectImpl
     */
    void save(Project project);

    /**
     * Gets the appropriate entries to the primary by key or null
     * @param key
     * @return ProjectImpl
     */
    Project getProjectByID(Long key);

    /**
     * It saves the state of the object group in the database
     * @param project
     */
    int update(Project project);

    /**
     * Removes the entry of the object from the database
     * @param project
     */
    void delete(Project project);

    /**
     * Returns a list of all the relevant records in the database
     * @return List of Projects
     * @throws SQLException
     */
    List<Project> getAll();
}
