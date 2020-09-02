package com.coursecube.springboot.rabbitmq;

import java.io.Serializable;

public class Order implements Serializable {
    int orderId;
    String orderDate;
    int custId;
    int totalQty;
    double totalCost;
    boolean status;

    public Order() {
    }

    public Order(int orderId, String orderDate, int custId, int totalQty, double totalCost, boolean status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.custId = custId;
        this.totalQty = totalQty;
        this.totalCost = totalCost;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate='" + orderDate + '\'' +
                ", custId=" + custId +
                ", totalQty=" + totalQty +
                ", totalCost=" + totalCost +
                ", status=" + status +
                '}';
    }
}
