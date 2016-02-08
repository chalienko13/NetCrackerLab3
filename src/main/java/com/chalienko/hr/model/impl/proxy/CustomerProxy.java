package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.dao.CustomerDao;
import com.chalienko.hr.dao.impl.oracle.DaoOracleFactory;
import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.impl.real.CustomerImpl;

import java.sql.SQLException;

/**
 * Created by Chalienko on 01.02.2016.
 */
public class CustomerProxy implements Customer {
    private Long id;
    private CustomerImpl customer;

    public CustomerProxy(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCustomerName() {
        if(customer == null){
            customer = downloadCustomer();
        }
        return customer.getCustomerName();
    }

    @Override
    public void setCustomerName(String customerName) {
        if(customer == null){
            customer = downloadCustomer();
        }
        customer.setCustomerName(customerName);
    }

    private CustomerImpl downloadCustomer(){
        CustomerImpl customer = null;
        try(DaoOracleFactory daoOracleFactory = new DaoOracleFactory()) {
            CustomerDao customerDao = daoOracleFactory.getCustomDao();
            customer = (CustomerImpl) customerDao.read(getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  customer;
    }
}
