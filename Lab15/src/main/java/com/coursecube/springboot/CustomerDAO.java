package com.coursecube.springboot;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    @Query("from Customer cust where email=?1 and phone=?2")
    List<Customer> getCustomers1(String email, long phone);

    @Query("from Customer cust where city=?1")
    List<Customer> getCustomers4(String city, Sort sort);

    @Query("from Customer cust where city=?1")
    List<Customer> getCustomers5(String city, Pageable pageable);

    @Query(
            value = "select * from mycustomers cust where city=?1 order by cid desc",
            nativeQuery = true
    )
    List<Customer> findCustomersByCity(String city);

    @Query(
            value = "select * from mycustomers where phone = :myphone",
            nativeQuery = true
    )
    List<Customer> findCustomersByPhone(@Param("myphone") long phone);

}
