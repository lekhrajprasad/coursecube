package com.coursecube.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping(value = "mycustomer/custid/{custId}")
    public Customer getCustomerById(@PathVariable("custId") int custId){

        Customer cust = null;
        try{
            cust = service.getCustomerById(custId);
        }catch (CustomerIDNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID Not Found", ex);
        }
        return cust;
    }

    @GetMapping(value = "mycustomer/phone/{phone}")
    public Customer getCustomerByPhone(@PathVariable("phone") long phone){
        Customer cust = null;
        try{
            cust = service.getCustomerByPhone(phone);
        }catch (CustomerIDNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone Number Not Found", ex);
        }
        return cust;
    }

    @GetMapping(value = "mycustomer/city/{city}")
    public List<Customer> getCustomerByCity(@PathVariable("city") String city){
        List<Customer> cust = null;
        try{
            cust = service.getCustomerByCity(city);
        }catch (CityNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "City Not Found", ex);
        }
        return cust;
    }

}
