package com.opennodetest.backend.entities;

import javax.persistence.*;

/**
 * This class is an entity that maps to the "orders" table in the database using the orderId as a primary key.
 * The class is annotated with JPA annotations to allow it to be mapped to the database.
 */
@Entity
@Table(name= "orders")
public class Order {
    @Id
    private String orderId;

    private long amount;

    private String status;

    public Order() {
    }

    public Order(String orderId, long amount, String status) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
