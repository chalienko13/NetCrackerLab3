package com.chalienko.hr.model;

import java.util.List;

/**
 * Created by Chalienko on 09-Dec-15.
 */
public class Customer extends Model {

    private static final long serialVersionUID = -4277472522111888961L;

    private String customerName;

    private List<Project> projects;

    public Customer() {
        super();
    }

    public Customer(Long id) {
        super(id);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{" + "id = " + getId() +
                "; customerName='" + getCustomerName() + '\'' +
                '}';
    }
}
