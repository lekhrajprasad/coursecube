package com.coursecube.springboot;

import java.math.BigInteger;
import java.util.List;

public interface CustomerDAO {
    public void addCustomer(Customer cust);
    public void updateCustomer(Customer cust);
    public void deleteCustomer(int cid);

    public Customer getCustomerByCid(int cid);

    public List<Customer> getAllCustomers();
    public List<Customer> getCustomersByCity(String city);
    public List<Customer> getCustomersByEmail(String email);
    public List<Customer> getCustomersByEmailAndPhone(String email, long phone);
    public List<Customer> getCustomersByEmailOrPhone(String email, long phone);

    public BigInteger getCustomerCount();
    public BigInteger getCustomerCountByCity(String city);
    public String getCityByEmail(String email);
    public long getPhoneByEmail(String email);
    public int getCidByPhone(long phone);

    public void deleteAllCustomersGrThenId(int id);
}
