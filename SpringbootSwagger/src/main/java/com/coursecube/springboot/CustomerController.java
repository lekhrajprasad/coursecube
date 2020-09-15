package com.coursecube.springboot;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CustomerController {

    @ApiOperation(value = "get the Customer by cid", response = double.class,
    notes = "Gives Customer full information by cid")
    @GetMapping(value = "/mycustomer/custid/{custId}", produces = "application/xml")
    public Customer getCustomerByCid(@PathVariable("custId") int custId){
        System.out.println("CC-getCustomerByCid() - " + custId);
        Customer cust = new Customer(custId, "Srinivas", "sri@jlc.com", 12345, "Blore");
        return cust;
    }

    @ApiOperation(value = " get the Customer By City",response = List.class,
            notes = "Gives Customers Full Information By City" )
    @GetMapping(value = "/mycustomer/city/{city}", produces = "application/json")
    public List<Customer> getCustomersByCity(@PathVariable("city") String city) {
        System.out.println("CC-getCustomersByCity() - " + city);
        List<Customer> custList = new ArrayList<>();
        custList.add(new Customer(101, "Sri", "sri@jlc.com", 111, city));
        custList.add(new Customer(102, "Vas", "vas@jlc.com", 222, city));
        custList.add(new Customer(103, "SD", "sd@jlc.com", 333, city));
        custList.add(new Customer(104, "DS", "ds@jlc.com", 444, city));
        custList.add(new Customer(105, "Dande", "dande@jlc.com", 555, city));
        custList.add(new Customer(106, "Dande", "dande@jlc.com", 555, city));
        return custList;
    }

}
