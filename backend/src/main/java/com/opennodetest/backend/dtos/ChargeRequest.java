package com.opennodetest.backend.dtos;

import java.io.Serializable;

/**
 * This class is a Data Transfer Object built for mapping requests to the createCharge API endpoint, only passing the
 * relevant parameters and "hiding" the rest within the relevant Order object.
 */
public class ChargeRequest implements Serializable {
    private static final long serialVersionUID = -7850841833179046964L;
    private long amount;
    private String order_id;

    public long getAmount() { return amount; }

    public void setAmount(long amount) { this.amount = amount; }

    public String getId() { return order_id; }

    public void setId(String id) { this.order_id = id; }

}
