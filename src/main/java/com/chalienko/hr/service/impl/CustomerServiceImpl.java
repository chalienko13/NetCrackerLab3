package com.chalienko.hr.service.impl;

import com.chalienko.hr.dao.CustomerDao;
import com.chalienko.hr.model.Customer;
import com.chalienko.hr.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Chalienko on 11.02.2016.
 */
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer getCustomer(Long id) {
        return customerDao.getCustomerByID(id);
    }

    @Override
    public void saveCustomer(Customer customer){
        customerDao.save(customer);
    }

    @Override
    public int updateCustomer(Customer customer){
        return customerDao.update(customer);
    }

    @Override
    public void deleteCustomer(Customer customer){
        customerDao.delete(customer);
    }

    @Override
    public List<Customer> getCustomers(){
        return customerDao.getAll();
    }
}
