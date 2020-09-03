package com.coursecube.springboot;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accno;

    private String atype;
    private String bcode;
    private double balance;

    public Account() {
    }

    public Account(String atype, String bcode, double balance) {
        this.atype = atype;
        this.bcode = bcode;
        this.balance = balance;
    }

    public Account(Integer accno, String atype, String bcode, double balance) {
        this.accno = accno;
        this.atype = atype;
        this.bcode = bcode;
        this.balance = balance;
    }

    public Integer getAccno() {
        return accno;
    }

    public void setAccno(Integer accno) {
        this.accno = accno;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accno=" + accno +
                ", atype='" + atype + '\'' +
                ", bcode='" + bcode + '\'' +
                ", balance=" + balance +
                '}';
    }
}
