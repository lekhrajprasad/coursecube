package com.coursecube.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDAO customerDAO;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Customer getCustomerById(int cid) {
        Optional<Customer> opt = customerDAO.findById(cid);
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public Customer getCustomerOne(int cid) {
        Customer customer = customerDAO.getOne(cid);
        return customer;
    }
}
