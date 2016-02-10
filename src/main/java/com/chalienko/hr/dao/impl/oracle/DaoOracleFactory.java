package com.chalienko.hr.dao.impl.oracle;

import com.chalienko.hr.dao.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Chalienko on 09-Dec-15.
 */
public class DaoOracleFactory implements DaoFactory {

    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String server = "localhost";
    private static String port = "1521";
    private static String sid = "orcl";
    private static String username = "C##CHAL";
    private static String password = "chalienko13";
    private static String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;

    private static DaoOracleFactory daoOracleFactory = new DaoOracleFactory();

    public static DaoOracleFactory getInstance(){
        return daoOracleFactory;
    }

    public DaoOracleFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws DAOException {
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new DAOException("Cannot get connection", e);
        }
    }

    @Override
    public ManagerDao getManagerDao() throws DAOException {
        return new ManagerOracleDao();
    }

    @Override
    public ProjectDao getProjectDao() throws DAOException {
        return new ProjectOracleDao();
    }

    @Override
    public CustomerDao getCustomDao() throws DAOException {
        return new CustomerOracleDao();
    }

    @Override
    public EmployeeDao getEmployeeDao() throws DAOException {
        return new EmployeeOracleDao();
    }

    @Override
    public void close() throws DAOException {
        try {
            getConnection().close();
        } catch (SQLException e) {
            throw new DAOException("Cannot close connection", e);
        }
    }
}
