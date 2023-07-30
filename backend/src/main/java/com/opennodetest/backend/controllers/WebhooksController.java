package com.opennodetest.backend.controllers;

import com.opennodetest.backend.dtos.StatusRequest;
import com.opennodetest.backend.entities.Order;
import com.opennodetest.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// TODO: switch to using a logger (log4j?) instead of System.out.println

/**
 * A controller for handling webhooks.
 * It provides endpoints to check the status of an order and update the status of an order.
 */

@RestController
@CrossOrigin
@RequestMapping("webhooks")
public class WebhooksController {

    @Autowired
    OrderService orderService;

    @GetMapping("/status")
    public ResponseEntity<?> getStatus(@RequestBody StatusRequest request) throws Exception {
        System.out.println("getStatus endpoint successfully called");

        if (request == null || request.getOrderId() == null) {
            return ResponseEntity.status(500).build();
        }

        Optional<Order> order = orderService.getOrder(request.getOrderId());

        System.out.println("checking order status");

        if (order.isPresent()) {
            if (order.get().getStatus().equals("paid")) {
                System.out.println("Order already paid");
                return ResponseEntity.status(200).build();
            }
        } else {
            System.out.println("Order not paid");
        }

        return ResponseEntity.status(400).build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStatus(@RequestBody String payload) throws Exception {
        System.out.println("updateStatus endpoint successfully called");
        System.out.println("payload: " + payload);
        // parse payload for the value after "keyword=" and before the next instance of "&"
        String status = payload.substring(payload.indexOf("status=") + 7, payload.indexOf("&", payload.indexOf("status=") + 7));
        String orderId = payload.substring(payload.indexOf("order_id=") + 9, payload.indexOf("&", payload.indexOf("order_id=") + 9));
        String amount = payload.substring(payload.indexOf("price=") + 6, payload.indexOf("&", payload.indexOf("price=") + 6));

        System.out.println("orderId: " + orderId);
        System.out.println("status: " + status);
        System.out.println("amount: " + Long.parseLong(amount));

        orderService.updateOrder(new Order(orderId, Long.parseLong(amount), status));

        return ResponseEntity.status(200).build();
    }

}
