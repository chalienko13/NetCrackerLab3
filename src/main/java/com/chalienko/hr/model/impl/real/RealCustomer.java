package com.chalienko.hr.model.impl.real;

import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.Project;

import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 */
public class RealCustomer implements Customer {

    private static final long serialVersionUID = -4277472522111888961L;

    private Long id;

    private String customerName;

    private List<Project> projects;

    public RealCustomer() {
        super();
    }

    public RealCustomer(Long id) {
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "RealCustomer{" + "id = " + getId() +
                "; customerName='" + getCustomerName() + '\'' +
                '}';
    }
}
