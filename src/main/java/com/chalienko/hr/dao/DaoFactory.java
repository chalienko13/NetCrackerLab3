package com.chalienko.hr.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Chalienko on 09-Dec-15.
 */
public interface DaoFactory {

    /**
     * Returns a connection to the database
     * @return connection
     * @throws SQLException
     */
    Connection getConnection() throws SQLException;

    /**
     * Gets the object for the persistent state of the object management Managers
     * @param connection
     * @return ManagersDao
     */
    ManagerDao getManagerDao(Connection connection) throws SQLException;

    /**
     * Gets the object for the persistent state of the object management Projects
     * @param connection
     * @return ProjectsDao
     */
    ProjectDao getProjectDao(Connection connection) throws SQLException;

    /**
     * Gets the object for the persistent state of the object management Customs
     * @param connection
     * @return
     */
    CustomerDao getCustomDao(Connection connection) throws SQLException;

    /**
     * Gets the object for the persistent state of the object management Employees
     * @param connection
     * @return EmployeeDao
     */
    EmployeeDao getEmployeeDao(Connection connection) throws SQLException;

}
