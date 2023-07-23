package com.opennodetest.backend.dtos;

import java.io.Serializable;

/**
 * This class is a Data Transfer Object built for mapping requests to the getStatus API endpoint, only passing the
 * relevant parameters and "hiding" the rest within the relevant Order object.
 */
public class StatusRequest implements Serializable {
    private static final long serialVersionUID = -5335122046902294528L;
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
