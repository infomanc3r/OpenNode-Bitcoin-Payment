package com.opennodetest.backend.controllers;

import com.opennodetest.backend.dtos.ChargeRequest;
import com.opennodetest.backend.entities.Order;
import com.opennodetest.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO: switch to using a logger (log4j?) instead of System.out.println

/**
 *  A controller for handling RESTful API requests for the Order entity and associated table.
 *  It provides an endpoint to create a charge and post it to the database.
 */

@RestController
@CrossOrigin
@RequestMapping("opennode")
public class OpenNodeController {

    @Autowired
    OrderService orderService;

    @PostMapping("/charge")
    public ResponseEntity<?> createCharge(@RequestBody ChargeRequest request) throws Exception {
        System.out.println("createCharge endpoint successfully called");

        orderService.addOrder(new Order(request.getId(), request.getAmount(), "unpaid"));

        System.out.println("Created charge with ID: " + request.getId()
                + ". Amount: " + request.getAmount());

        return ResponseEntity.status(200).build();
    }
}
