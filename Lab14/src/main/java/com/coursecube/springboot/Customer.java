package com.coursecube.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mycustomers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid")
    private int cid;

    private String cname;
    private String email;
    private long phone;
    private String city;


    private Double bal;

    public Customer() {
    }

    public Customer(String cname, String email, long phone, String city, Double bal) {
        this.cname = cname;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.bal = bal;
    }

    public Customer(int i, String name, String email, int phone, String city, Double bal) {
        this.cid = i;
        this.cname = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.bal = bal;
    }

    public Double getBal() {
        return bal;
    }

    public void setBal(Double bal) {
        this.bal = bal;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", city='" + city + '\'' +
                ", bal=" + bal +
                '}';
    }
}
