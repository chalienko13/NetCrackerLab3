package com.chalienko.hr.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Chalienko on 09-Dec-15.
 */
public interface DaoFactory extends AutoCloseable {

    /**
     * Returns a connection to the database
     * @return connection
     * @throws SQLException
     */
    Connection getConnection() throws DAOException;

    /**
     * Gets the object for the persistent state of the object management Managers
     * @return ManagersDao
     */
    ManagerDao getManagerDao() throws DAOException;

    /**
     * Gets the object for the persistent state of the object management Projects
     * @return ProjectsDao
     */
    ProjectDao getProjectDao() throws DAOException;

    /**
     * Gets the object for the persistent state of the object management Customs
     * @return
     */
    CustomerDao getCustomDao() throws DAOException;

    /**
     * Gets the object for the persistent state of the object management Employees
     * @return EmployeeDao
     */
    EmployeeDao getEmployeeDao() throws DAOException;

}
