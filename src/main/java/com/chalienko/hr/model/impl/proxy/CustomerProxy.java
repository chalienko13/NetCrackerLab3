package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.impl.real.CustomerImpl;
import com.chalienko.hr.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        CustomerService customerService = (CustomerService) appContext.getBean("customerServiceImpl");
        return (CustomerImpl) customerService.getCustomer(getId());
    }
}
