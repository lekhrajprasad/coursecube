package com.coursecube.springboot;

public class TxInfo {
    private int accno;
    private double amount;

    public TxInfo() {
    }

    public TxInfo(double amount) {
        this.amount = amount;
    }

    public TxInfo(int accno, double amount) {
        this.accno = accno;
        this.amount = amount;
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TxInfo{" +
                "accno=" + accno +
                ", amount=" + amount +
                '}';
    }
}
