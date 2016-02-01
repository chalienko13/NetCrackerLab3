package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.dao.CustomerDao;
import com.chalienko.hr.dao.impl.oracle.OracleDaoFactory;
import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.impl.real.RealCustomer;

import java.sql.SQLException;

/**
 * Created by Chalienko on 01.02.2016.
 */
public class ProxyCustomer implements Customer {
    private Long id;
    private RealCustomer customer;

    public ProxyCustomer(Long id) {
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

    private RealCustomer downloadCustomer(){
        RealCustomer customer = null;
        try(OracleDaoFactory oracleDaoFactory = new OracleDaoFactory()) {
            CustomerDao customerDao = oracleDaoFactory.getCustomDao();
            customer = (RealCustomer) customerDao.read(getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  customer;
    }
}
