package com.chalienko.hr.dao.impl.oracle;

import com.chalienko.hr.dao.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Chalienko on 09-Dec-15.
 */
public class OracleDaoFactory implements DaoFactory {

    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String server = "localhost";
    private static String port = "1521";
    private static String sid = "orcl";
    private static String username = "C##CHAL";
    private static String password = "chalienko13";
    private static String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;

    public OracleDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    @Override
    public ManagerDao getManagerDao() throws SQLException {
        return new OracleManagerDao(getConnection());
    }

    @Override
    public ProjectDao getProjectDao() throws SQLException {
        return new OracleProjectDao(getConnection());
    }

    @Override
    public CustomerDao getCustomDao() throws SQLException {
        return new OracleCustomerDao(getConnection());
    }

    @Override
    public EmployeeDao getEmployeeDao() throws SQLException {
        return new OracleEmployeeDao(getConnection());
    }
}
