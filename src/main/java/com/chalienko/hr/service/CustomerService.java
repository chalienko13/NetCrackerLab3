package com.chalienko.hr.service;

import com.chalienko.hr.model.Customer;

import java.util.List;

/**
 * Created by Chalienko on 11.02.2016.
 */
public interface CustomerService {

    Customer getCustomer(Long id);

    void saveCustomer(Customer customer);

    int updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    List<Customer> getCustomers();
}
