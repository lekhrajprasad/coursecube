package com.coursecube.springboot;

import java.util.List;

public interface CustomerDAO {
    public void addCustomer(Customer cust);
    public List<Customer> getAllCustomers();
    public void deleteAllCustomersGrThenId(int id);
    public List<Customer> getCustomerByCity(String city);
}
