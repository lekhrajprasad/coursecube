package com.coursecube.springboot;


import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlRootElement;
@ApiModel(value = "Customer contains cid, Cname, Email, Phone and City")
@XmlRootElement
public class Customer {
    private int customerId;
    private String customerName;
    private String email;
    private long phone;
    private String city;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String email, long phone, String city) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.city = city;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", city='" + city + '\'' +
                '}';
    }
}
