package com.opennodetest.backend.controllers;

import com.opennodetest.backend.dtos.ChargeRequest;
import org.brunocvcunha.opennode.api.OpenNodeService;
import org.brunocvcunha.opennode.api.OpenNodeServiceFactory;
import org.brunocvcunha.opennode.api.model.OpenNodeCharge;
import org.brunocvcunha.opennode.api.model.OpenNodeCreateCharge;
import org.brunocvcunha.opennode.api.model.OpenNodeCurrency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("opennode")
public class OpenNodeController {
    OpenNodeService openNodeService = OpenNodeServiceFactory
            .buildClient("{fbf61361-d7f0-4a85-a880-e58566edec42}");
    @PostMapping("/charge")
    public ResponseEntity<?> createCharge(@RequestBody ChargeRequest request) throws Exception {
        System.out.println("createCharge endpoint successfully called");

        // TODO: add backing up order to PostgreSQL database

        System.out.println("Created charge with ID: " + request.getId()
                + ". Amount: " + request.getAmount()
                + ". Invoice: ");

        return ResponseEntity.status(200).build();
    }

    @PostMapping("/webhooks/")
}
