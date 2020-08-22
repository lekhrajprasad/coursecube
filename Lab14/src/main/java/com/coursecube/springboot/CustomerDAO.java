package com.coursecube.springboot;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    List<Customer> getCustomersByCname(String cname);
    List<Customer> readCustomersByCname(String cname);
    List<Customer> findCustomersByCname(String cname);
    List<Customer> getByCname(String cname);

    List<Customer> getByCnameAndEmail(String cname, String email);
    List<Customer> getCustomerByEmailOrPhone(String email, long phone);

    List<Customer> getCustomersByCnameLike(String cname);
    List<Customer> getCustomersByCnameStartsWith(String cname);
    List<Customer> getCustomersByCnameEndsWith(String cname);
    List<Customer> getCustomersByEmailContains(String email);

    List<Customer> getCustomersByCityIn(String... cities);
    List<Customer> getCustomersByCityNotIn(String... cities);

    long countCustomersByCity(String city);
    long countCustomersByCityIn(String... cities);
    long countCustomersByCityNotIn(String... cities);

    long countCustomersByCnameLike(String cname);
    long countCustomersByBalNull();
    long countCustomersByBalNotNull();

    List<Customer> getCustomersByPhoneNull();
    List<Customer> getCustomersByPhoneNotNull();
    List<Customer> getCustomersByBal(double bal);
    List<Customer> getCustomersByBalBetween(double bal1,double bal2);
    List<Customer> getCustomersByBalIsGreaterThan(double bal);
    List<Customer> getCustomersByBalLessThan(double bal);
    List<Customer> getCustomersByBalGreaterThanEqual(double bal);
    List<Customer> getCustomersByBalLessThanEqual(double bal);

    List<Customer> findAllByOrderByCity(Sort sort);
    List<Customer> findByCityOrderByCidDesc(String city);
    List<Customer> findCustomersByCityOrderByCidDesc(String city);
    List<Customer> findByCityAndBalBetweenOrderByCidDesc(String city, double bal1, double bal2);
    List<Customer> findByCityAndBalLessThanOrderByCityDesc(String city, double bal);





























}
