package com.coursecube.springboot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public Customer getCustomerById(int custId){
        Customer cust = null;
        if (custId >= 100) {
            cust = new Customer(custId, "lekhraj", "lekh@gmail", 12345, "Pune");
        } else {
            throw new CustomerIDNotFoundException();
        }
        return cust;
    }
    public Customer getCustomerByPhone(long phone) {
        Customer cust = null;
        if (phone >= 5000) {
            cust = new Customer(101, "lekhraj", "lekh@gmail", phone, "Pune");
        } else {
            throw new InvalidPhoneNumberException();
        }
        return cust;
    }
    public List<Customer> getCustomerByCity(String city) {
        List<Customer> customerList;
        if (city.equals("Pune")) {
            customerList = new ArrayList<>();
            customerList.add(new Customer(101, "lekhraj prasad", "lekh1@gmail", 12345, city));
            customerList.add(new Customer(102, "lekhraj prasad", "lekh2@gmail", 12346, city));
            customerList.add(new Customer(103, "lekhraj_prasad", "lekh3@gmail", 12347, city));
            customerList.add(new Customer(104, "lekhraj.prasad", "lekh4@gmail", 12348, city));
            customerList.add(new Customer(105, "lekhraj@prasda", "lekh1@gmail", 12349, city));
            customerList.add(new Customer(106, "lekhraj prasad", "lekh1@gmail", 12346, city));
            customerList.add(new Customer(107, "lekhraj prasad", "lekh2@gmail", 12347, city));
        } else {
            throw new CityNotFoundException();
        }
        return customerList;
    }
}
