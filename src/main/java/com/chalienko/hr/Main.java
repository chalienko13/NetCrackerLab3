package com.chalienko.hr;

import com.chalienko.hr.dao.CustomerDao;
import com.chalienko.hr.dao.DaoFactory;
import com.chalienko.hr.dao.impl.oracle.OracleDaoFactory;
import com.chalienko.hr.model.Customer;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Chalienko on 06-Dec-15.
 */
public class Main {
    public static void main(String[] args) {
        DaoFactory daoFactory = new OracleDaoFactory();
        Connection con = null;
        Customer customer = new Customer();
        try {
            con = daoFactory.getConnection();
            CustomerDao dao = daoFactory.getCustomDao(con);
            customer = dao.read(1L);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(customer);
    }
}
